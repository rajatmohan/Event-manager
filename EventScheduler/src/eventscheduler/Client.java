package eventscheduler;
import java.io.*;
import java.net.*;

public class Client {
    
    public String username;
    public String password;
    public String email;
    public int id;
    public int groupId;
    public boolean isConnected;
    public int portNum;
    public String serverHostName;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;
    
    Client(String username, String password, String serverHostName, int portNum){
        this.username = username;
        this.password = password;
        this.serverHostName = serverHostName;
        this.portNum = portNum;
        isConnected = false;
        clientSocket = null;
    }
    
    @SuppressWarnings("UseSpecificCatch")
    
    /*function to establish connection with server*/
    public void connectToServer(){
        System.out.println ("New Client connecting to server: " + 
                serverHostName + " at portNum: " + portNum);
        try {
            clientSocket = new Socket(serverHostName, portNum);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            isConnected = true;
        }
        catch (UnknownHostException e) {
            System.out.println("Unknown host: " + serverHostName + " " + e);
            isConnected = false;
        }
        catch (IOException e) {
            System.out.println("I/O stream error for server: " + serverHostName + " " + e);
            isConnected = false;
        }
    }
    
    /*function to disconnect from server*/
    public void disconnectFromServer(){
        try{
            String output = "close?";
            out.println(output);
            clientSocket.close();
            out.close();
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    /*function to login*/
    public boolean login(){
        if(!isConnected)  
            return false;
        String output = "login?username=" + username + "&password=" + password;
        try{
            out.println(output);
            if("err".equals(in.readLine())){
                return false;
            }
            System.out.println("Logged in!");
            groupId = Integer.parseInt(in.readLine());      //group id of client is retrieved
            id = Integer.parseInt(in.readLine());           //id of client is retrieved
            return true;
        } catch(IOException e){
            System.out.println("Client: " + e);
        }
        return false;  
    }
    
}