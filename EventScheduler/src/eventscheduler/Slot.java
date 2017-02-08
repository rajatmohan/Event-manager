package eventscheduler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Slot {
    
    private final PrintWriter out;
    private final BufferedReader in;
    
    public Slot(Client client)throws IOException{
        out = client.out;
        in = client.in;
    }
    
    /*function which returns array of available slots on specified venue*/
    public String[] getSlots(String date, String venue){
        try {
            String output, input, input2;
            String sl[] = new String[50];
            output="viewslots?date=" + date + "&venue=" + venue;
            out.println(output);
            int i = 0; 
            input = in.readLine();
            if("pass".equals(input)){
                System.out.println("Slots returned.");
                while(true){
                    input = in.readLine();
                    if("%%".equals(input))
                        break;
                    else{
                        input2 = in.readLine();
                        sl[i++] = input.substring(11, 11 + 8) + " - " + input2.substring(11, 11 + 8);
                    }
                }
                sl[i++] = "%%";
                return sl;
            }
            else{
                System.out.println("Slots not returned.");
            }
        } catch (IOException e) {
            System.out.println("Slot: " + e);
        }
        return null;
    }
}
