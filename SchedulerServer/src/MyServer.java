import java.net.*;
import java.io.*;

public class MyServer{
    
    protected Socket clientSocket;
    
    @SuppressWarnings("null")
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3000);
            System.out.println("Connection Socket Created");
            try { 
                while (true) {      //server starts and keeps adding sockets with clients
                    System.out.println ("Waiting for Connection");
                    MyServer newclient = new MyServer (serverSocket.accept());
                    newclient.threadstart();
                }
            }
            catch (IOException e){
                System.out.println("MyServer: Accept failed. " + e);
            }
        }
        catch (IOException e){
            System.out.println("MyServer: Could not listen on port. " + e);
            System.exit(1);
        }
        finally{
            try {
                serverSocket.close();
            }
            catch (IOException e){
                System.out.println("MyServer: Could not close port." + e);
            }
        }  
     }
     private MyServer (Socket clientSock){
         clientSocket = clientSock;
     }
     private void threadstart(){                //a separate thread handles each client
         ClientThread newclient = new ClientThread(clientSocket);
         newclient.start();
     }
     
}
