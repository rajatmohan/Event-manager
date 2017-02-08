package eventscheduler;

import java.io.IOException;

public class Admin extends Client {
    
    /*two different constructors to initialize admin object*/
    public Admin(String username, String password, String serverHostName, int portNum){
        super(username, password, serverHostName, portNum);
    }
    
    public Admin(Client client) {
        super(client.username, client.password, client.serverHostName, client.portNum);
        this.clientSocket = client.clientSocket;
        this.email = client.email;
        this.isConnected = client.isConnected;
        this.in = client.in;
        this.out = client.out;
        this.id = client.id;
    }
    
    /*function to add other clients*/
    public boolean addClient(String username, String passwd, String group, String email){
        int groupid = 0;
        try{
            out.println("getgroupid?" + group);
            groupid = Integer.parseInt(in.readLine());
            System.out.println("group id " + groupid);
        } catch (IOException e) {
            System.out.println("Admin Error: " + e);
        }
        String output = "adduser?";
        output += "username=" + username;
        output += "&password=" + passwd;
        output += "&groupid=" + groupid;
        output += "&email=" + email;
        out.println(output);
        try {
            if("err".equals(in.readLine()))
                return false;
        } catch (IOException e) {
           System.out.println("Admin Error: " + e);
        }
        return true;
    }
    
    /*function to add a venue*/
    public boolean addVenue(String venuename, String blocked){
        Venue v = null;
        try {
            v = new Venue(this);
        } catch (IOException e) {
            System.out.println(e);
        }
        return v.addVenue(venuename, blocked);
    }
    
    /*function to remove a venue*/
    public boolean removeVenue(String venuename){
        Venue v = null;
        try {
            v = new Venue(this);
        } catch (IOException e) {
            System.out.println(e);
        }
        return v.removeVenue(venuename);
    }
    
}
