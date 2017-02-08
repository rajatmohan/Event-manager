import java.net.*;
import java.io.*;
import java.sql.*;

public class ClientThread extends Thread{
    
    private final Socket clientSocket;
    private String input;
    PrintWriter out;
    BufferedReader in; 
    public Database connect;
    
    public ClientThread(Socket clientSoc){
        this.clientSocket = clientSoc;
        connect = new Database();
    }
    
    @Override
    public void run(){
        System.out.println("New Communication Thread Started.");
        System.out.println(this.getName());
        System.out.println(clientSocket.getPort());
        try{
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));
            while ((input = in.readLine()) != null){
                if(processInput())
                   break;
            }
            out.close();
            in.close();
            clientSocket.close();
        } catch(IOException e){
            System.out.println("Problem with Communication Server. " + e);
            System.exit(1);
        }
    }
    
    /*
    each of the function implemented below returns 'pass' if the query it executes is successful
    and 'err' otherwise.
    */
    
    /*executes login query passes group id and user id to client if login is successful*/
    synchronized private void login(){
        int start = input.indexOf('?') + 1;
        int len = input.length();
        int temp, temp2;
        String key, value;
        String username = "", password = "";
        while((temp = input.indexOf('=', start)) != -1){
            key = input.substring(start, temp);
            start = temp + 1;
            temp2 = input.indexOf('&', start);
            if(temp2 == -1){
                value = input.substring(start, len);
                start = len;
            }
            else{
                value = input.substring(start, temp2);
                start = temp2 + 1;
            }
            if("username".equals(key)){
                username = value;
            }
            if("password".equals(key)){
                password = value;
            }
        }
        String query = "SELECT * FROM users WHERE username = ?";
        String param[] = new String[1];
        param[0] = username;
        connect.query(query, param);
        if(connect.errors()){
            System.out.println("Error in login query.");
        }
        else{     
            try {
                ResultSet resultArr = connect.results();
                if(resultArr.next() && password.equals(resultArr.getString("password"))){
                    out.println("pass");
                    out.println(resultArr.getInt("groupid"));
                    out.println(resultArr.getInt("id"));
                } 
                else {
                    out.println("err");
                }
            } catch(SQLException e) {
                out.println("ClientThread->login: " + e);
            }
        }
    }
    
    /*adds event to db*/
    synchronized private void addEvent(){
        int start = input.indexOf('?') + 1;
        int len = input.length();
        int temp, temp2;
        String organizerId="";
        String key, value;
        String keys[] = new String[10];
        String values[] = new String[10];
        String notAllowed="";
        String endtime="";
        int i = 0, j;
        while((temp = input.indexOf('=', start)) != -1){
            key = input.substring(start, temp);
            start = temp + 1;
            temp2 = input.indexOf('&', start);
            if(temp2 == -1){
                value = input.substring(start, len);
                start = len;
            }
            else{
                value = input.substring(start,temp2);
                start = temp2+1;
            }
            keys[i] = key;
            values[i] = value;
            ++i;
        }
        for(int k = 0; k < i; ++k){
            if("starttime".equals(keys[k]))
                notAllowed = values[k];
            if("organizerid".equals(keys[k]))
                organizerId = values[k];
            if("endtime".equals(keys[k]))
                endtime = values[k];
        }
        /*to check if user has already booked a slot that day*/
        String query1 = "Select COUNT(*) from events where cast(starttime as DATE) = ? and organizerid = ? ";
        String param1[] = new String[2];
        param1[0]=notAllowed.trim().substring(0,10);
        param1[1]=organizerId;
        connect.query(query1,param1);
        if(!connect.errors()){
            try {
                ResultSet st = connect.results();
                if(st.next()){
                    int r = st.getInt("COUNT(*)");
                    if(r > 0){
                        out.println("err");
                        return ;
                    }
                }
            } catch (SQLException e) {
                System.out.println("ClientThread: " + e);
            }
        }
        else
            return;
        
        /*to check if already slot is occupied*/
        String query3 = "SELECT COUNT(*) from events where ( starttime >= ? and starttime < ? )"
                + " or ( endtime > ? and endtime <= ? ) ";
        String param3[]=new String[4];
        param3[0] = param3[2] = notAllowed;
        param3[1] = param3[3] = endtime;
        connect.query(query3, param3);
        if(!connect.errors()){
            try {
                ResultSet st = connect.results();
                if(st.next()){
                    int r = st.getInt("COUNT(*)");
                    if(r > 0){
                        out.println("err");
                        return ;
                    }
                }
            } catch (SQLException e) {
                System.out.println("ClientThread: " + e);
            }
        }
        else
            return;
        String query = "INSERT into events (";
        String param[] = new String[i];
        for(j = 0; j < i; ++j){
            query = query + keys[j];
            if(j != i - 1){
                query += ",";
            }
            param[j] = values[j];
        }
        query += ") values (";
        for(j = 0; j < i; ++j){
            query += '?';
            if(j != i - 1){
                query += ",";
            }
        }
        query += ")";
        connect.query(query, param);
        if(connect.errors()){
            out.println("err");
        }
        else{
            out.println("pass");
        }   
    }
    
    /*passes list of all events*/
    synchronized private void viewEvents(){
        String query="SELECT events.*, venues.venuename, users.username FROM events, venues, users"
                + " WHERE events.starttime >= CURRENT_TIMESTAMP"
                + " AND venues.id = events.venueid AND events.organizerid = users.id";
        connect.query(query);
        if(connect.errors())
            out.println("err");
        else{  
            try{
                ResultSet resultArr = connect.results();
                String[] colName = {"eventname", "username", "venuename", "starttime",
                    "endtime", "description"};
                out.println("pass");
                while(resultArr.next()){
                    for(int i = 0; i < colName.length; ++i){
                        out.println(resultArr.getString(colName[i]));
                    }
                }
                out.println("%%");
            }
            catch(Exception e){
                System.out.println("ClientThread->viewEvents: " + e);
            }
        }
    }
    
    /*passes events added by user of given userid*/
    synchronized private void showMyEvents(){
        String userid = input.substring(input.indexOf('=') + 1);
        String query="SELECT events.*, venues.venuename, users.username FROM events, venues, users"
                + "  WHERE events.starttime >= CURRENT_TIMESTAMP"
                + " AND venues.id = events.venueid AND users.id = events.organizerid AND events.organizerid = " + userid;
        System.out.println(userid);
        connect.query(query);
        if(connect.errors())
            out.println("err");
        else{  
            try{
                ResultSet resultArr = connect.results();
                String[] colName = {"id", "eventname", "venuename", "starttime",
                    "endtime", "description"};
                out.println("pass");
                while(resultArr.next()){
                    for(int i = 0; i < colName.length; ++i){
                        out.println(resultArr.getString(colName[i]));
                    }
                }
                out.println("%%");
            }
            catch(Exception e){
                System.out.println("ClientThread->showMyEvents: " + e);
            }
        }        
    }
    
    /*removes an event*/
    synchronized private void removeEvent(){
        String eventid = input.substring(input.lastIndexOf('=') + 1);
        if(connect.delete("events", eventid)){
            out.println("pass");
        }
        else{
            out.println("err");
        }
    }
    
    /*adds a venue*/
    synchronized private void addVenue(){
        int start = input.indexOf('?') + 1;
        int len = input.length();
        int temp, temp2;
        String key, value;
        String name = "", blocked = "";
        while((temp = input.indexOf('=', start)) != -1){
            key = input.substring(start, temp);
            start = temp + 1;
            temp2 = input.indexOf('&', start);
            if(temp2 == -1){
                value = input.substring(start, len);
                start = len;
            }
            else{
                value = input.substring(start, temp2);
                start = temp2 + 1;
            }
            if("venuename".equals(key))
                name = value;
            if("blocked".equals(key))
                blocked = value;
        }
        String query = "INSERT INTO venues (venuename, blocked) VALUES (?, ?)";
        String[] param = new String[2];
        param[0] = name;
        param[1] = blocked;
        connect.query(query, param);
        if(connect.errors())
            out.println("err");
        else
            out.println("pass");
    }
    
    /*removes a venue*/
    synchronized private void removeVenue(){
        int temp = input.indexOf('=');
        String value = input.substring(temp + 1);
        String query = "DELETE FROM venues WHERE venuename = ? ";
        String[] param = new String[1];
        param[0] = value;
        connect.query(query, param);
        if(connect.errors())
            out.println("err");
        else
            out.println("pass");
    }
    
    /*adds a user*/
    synchronized private void addUser(){
        int start = input.indexOf('?') + 1;
        int len = input.length();
        int temp, temp2;
        String key, value;
        String query = "INSERT INTO users (";
        String keys[] = new String[10];
        String values[] = new String[10];
        int i = 0, j;
        while((temp = input.indexOf('=', start)) != -1){
            key = input.substring(start, temp);
            start = temp + 1;
            temp2 = input.indexOf('&', start);
            if(temp2 == -1){
                value = input.substring(start, len);
                start = len;
            }
            else{
                value = input.substring(start, temp2);
                start = temp2 + 1;
            }
            keys[i] = key;
            values[i++] = value;
        }
        String param[] = new String[i];
        for(j = 0; j < i; ++j){
            query += keys[j];
            if(j != i - 1)
                query += ",";
            param[j] = values[j];
        }
        query += ") VALUES (";
        for(j = 0; j < i; ++j){
            query += '?';
            if(j != i - 1)
                query += ',';
        }
        query += ')';
        connect.query(query, param);
        if(connect.errors())
            out.println("err");
        else
            out.println("pass");
    }
    
    synchronized private void removeUser(){
        
    }
    
    /*passes available slot on given date and venue*/
    synchronized private void viewSlots(){
            int start = input.indexOf('?') + 1;
            int temp, temp2;
            int len = input.length();
            String key,value;
            String date = "";
            String venue = null;
            while((temp = input.indexOf('=', start))!=-1){
                key = input.substring(start,temp);
                start = temp + 1;
                temp2 = input.indexOf('&', start);
                if(temp2 == -1){
                    value = input.substring(start, len);
                    start = len;
                }
                else{
                    value = input.substring(start, temp2);
                    start = temp2 + 1;
                }
                if(key.equals("date"))
                    date = value;
                if(key.equals("venue"))
                    venue = value;
            }
            String low = date + " 00:00:00";
            String high = date + " 23:59:00";
            if(!"".equals(date)){
                String query = "Select events.* , venues.* from events, venues where venues.venuename = ? and "
                         + "events.starttime >= ? "
                         + "and events.endtime <= ? and events.venueid = venues.id order by events.starttime";
                String param[] = new String[3];
                param[1]=low;
                param[2]=high;
                param[0]=venue;
                Timestamp st, et;
                Timestamp startingSlot, endingSlot;
                startingSlot = Timestamp.valueOf(date + " 08:00:00");
                endingSlot = Timestamp.valueOf(date + " 20:00:00");
                connect.query(query, param);
                if(!connect.errors()){
                    try{
                        out.println("pass");
                        ResultSet rows = connect.results();                        
                        while(rows.next()){                
                            st = rows.getTimestamp("starttime");
                            et = (rows.getTimestamp("endtime"));
                            if(st.after(startingSlot)){
                                out.println(startingSlot);
                                out.println(st);
                                startingSlot=et;
                            }
                        }
                        if(startingSlot.before(endingSlot)){
                            out.println(startingSlot);
                            out.println(endingSlot);
                        }
                        out.println("%%");
                    }
                    catch(Exception e){
                        System.out.println("Client Thread->viewSlots: " + e);
                        out.println("err");
                    }
                }
                else{
                    out.println("err");
                }
            }
    }
    
    /*passes groupid of user*/
    synchronized private void getGroupId(){
        String name = input.substring(input.indexOf('?') + 1);
        String query = "SELECT * FROM groups WHERE name = ?";
        String param[] = new String[1];
        param[0] = name;
        connect.query(query, param);
        if(connect.errors())
            System.out.println("Some error occurred.");
        else{
            ResultSet resultArr = connect.results();
            try {
                if(resultArr.next()){
                    out.println(resultArr.getInt("id"));
                }
            } catch (SQLException e) {
                System.out.println("ClientThread->getGroupId: " + e);
            }
        }
    }
    
    synchronized private String getGroupName(int groupId){
        String query = "SELECT * FROM groups WHERE id = ?";
        String param[] = new String[1];
        param[0] = "" + groupId;
        connect.query(query, param);
        if(connect.errors())
            System.out.println("Some error occurred.");
        else{
            ResultSet resultArr = connect.results();
            try {
                if(resultArr.next()){
                    return resultArr.getString("name");
                }
            } catch (SQLException e) {
                System.out.println("ClientThread->getGroupName: " + e);
            }
        }
        return "";
    }
    
    synchronized private void viewVenues(){
        String groupId = input.substring(input.indexOf('=') + 1);
        String gpName = getGroupName(Integer.parseInt(groupId));
        String query = "SELECT * from venues ";
        connect.query(query);
        if(connect.errors())
            System.out.println("Some error occurred.");
        else{
            ResultSet resultArr = connect.results();
            try {
                out.println("pass");
                while(resultArr.next()){
                    String[] gp = resultArr.getString("blocked").split(",");
                    int i;
                    for(i = 0; i < gp.length; ++i){
                        gp[i].trim();
                        if(gp[i].equalsIgnoreCase(gpName)){
                           break; 
                        }
                    }
                    if(i == gp.length)
                        out.println(resultArr.getString("venuename"));
                }
                out.println("%%");
            } catch (SQLException e) {
                System.out.println("ClientThread->viewVenues: " + e);
                out.println("err");
            }
        }
    }
    
    synchronized private void getVenueId(){
        String name = input.substring(input.indexOf('=') + 1);
        String query = "SELECT * FROM venues WHERE venuename = ?";
        String param[] = new String[1];
        param[0] = name;
        connect.query(query, param);
        if(connect.errors())
            System.out.println("Some error occurred.");
        else{
            ResultSet resultArr = connect.results();
            try {
                if(resultArr.next()){
                    out.println(resultArr.getInt("id"));
                }
            } catch (SQLException e) {
                System.out.println("ClientThread->getVenueId: " + e);
            }
        }
    }
    
    synchronized private boolean processInput(){
        String action = "";
        try{
            action = input.substring(0, input.indexOf('?'));
            if("".equals(action))
                action = input.substring(0);
        } catch(Exception e){
            System.out.println("Client Thread->process input: " + e);
            return true;
        }
        switch(action){
            case "close":
                return true;
            case "login":
                login();
                return false;
            case "addevent":
                addEvent();
                return false;
            case "viewevents":
                viewEvents();
                return false;
            case "showmyevents":
                showMyEvents();
                return false;
            case "removeevent":
                removeEvent();
                return false;
            case "addvenue":
                addVenue();
                return false;
            case "removevenue":
                removeVenue();
                return false;
            case "adduser":
                addUser();
                return false;
            case "removeuser":
                removeUser();
                return false;
            case "getgroupid":
                getGroupId();
                return false;
            case "viewslots":
                viewSlots();
                return false;
            case "viewvenues":
                viewVenues();
                return false;
            case "getvenueid":
                getVenueId();
                return false;
            default:
                return false;
        }
    }
    
}
