package eventscheduler;
import java.net.*;
import java.io.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Event {
    
    private String name;
    private String startTime;
    private String endTime;
    private String date;
    private String venuename;
    private String description;
    private int organizerId; 
    private String venueId;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public Event(Socket clientSocket) throws IOException {        
        this.clientSocket = clientSocket;
        out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }
    
    public boolean createEvent(String name, String startTime, String endTime
            , String date, String venuename, int organizerId,
            String description) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.venuename = venuename;
        this.organizerId = organizerId;
        this.description = description;
        try{
            return addEvent();
        }
        catch(Exception e){
            System.out.println("Event: " + e);
        }
        return false;
    }
    
    /*function to add a event*/
    private boolean addEvent() throws IOException {
        String output = "getvenueid?venuename=" + venuename;
        out.println(output);
        venueId = in.readLine();
        output = "addevent?eventname=" + name;
        output += "&organizerid=" + organizerId;
        output += "&venueid=" + venueId;
        output += "&description=" + description;
        output += "&starttime=" + date + " " + startTime;
        output += "&endtime=" + date + " " + endTime;
        out.println(output); 
        if("err".equals(in.readLine()))
           return false;
        else
           return true;
    }
    
    /*function to view the table of events on view event panel*/
    public void viewEvents(DefaultTableModel mod) throws IOException, SQLException {
        String output = "viewevents?";
        String[] cell = new String[10];
        out.println(output); 
        if("err".equals(in.readLine())){
            System.out.println("Events not viewed.");
        }
        else{
            System.out.println("Events viewed Succsessfully.");
            while(true){
                cell[0] = in.readLine();
                if("%%".equals(cell[0])){
                    break;
                }
                for(int i = 1; i < mod.getColumnCount(); ++i){
                    cell[i] = in.readLine();
                }
                mod.insertRow(mod.getRowCount(), cell);
            }
        }
    }
      
    /*function to show the events added by the client on my events panel*/
    public void showMyEvents(DefaultTableModel mod, Client client) throws IOException, SQLException {
        String output = "showmyevents?id=" + client.id;
        Object[] cell = new Object[10];
        out.println(output); 
        if("err".equals(in.readLine())){
            System.out.println("My events not shown.");
        }
        else{
            System.out.println("My events shown successfully");
            while(true){
                cell[0] = in.readLine();
                if("%%".equals(cell[0])){
                    break;
                }
                int i;
                for(i = 1; i < 6; ++i){
                    cell[i] = in.readLine();
                }
                mod.insertRow(mod.getRowCount(), cell);
            }
        }
    }

    /*function to remove any event by selecting it on my events pane*/
    void removeEvent(String eventid) throws IOException {
        String output = "removeevent?eventid=" + eventid;
        System.out.println(output);
        out.println(output);
        if("err".equals(in.readLine())){
            System.out.println("Event not removed.");
        }
        else{
            System.out.println("Event removed successfully");
        }
    }
    
}
