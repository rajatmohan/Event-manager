package eventscheduler;

import java.io.*;
import java.io.IOException;

public class Venue {
    
    String name;
    private final PrintWriter out;
    private final BufferedReader in;
    
    public Venue(Client client) throws IOException{
        out = client.out;
        in = client.in;
    }
    
    /*function to add venue*/
    public boolean addVenue(String venuename, String blocked){
        String output = "addvenue?venuename=" + venuename + "&blocked=" + blocked;
        try {
            out.println(output);
            if("err".equals(in.readLine()))
                return false;
        } catch (IOException e) {
           System.out.println("Venue: " + e);
        }
        return true;
    }
    
    /*function to remove venue*/
    public boolean removeVenue(String venuename){
        String output = "removevenue?name=" + venuename;
        try {
            out.println(output);
            if("err".equals(in.readLine()))
                return false;
        } catch (IOException e) {
           System.out.println("Venue: " + e);
        }
        return true;
    }
    
    /*function to view venues not blocked by a group*/
    public  String[] viewVenues(int groupid){
        String output = "viewvenues?groupid=" + groupid;
        String input = "";
        String ven[] = new String[25];
        try {
            out.println(output);
            if("err".equals(in.readLine())){
                System.out.println("Venue not viewed.");
            }
            else{
                int i = 0;
                while(true){
                    input = in.readLine();
                    if("%%".equals(input))
                        break;
                    ven[i++] = input;
                }
                ven[i++] = "%%";
            }
        } catch (IOException e) {
           System.out.println("Venue: " + e);
        }
        return ven;
    }
}
