



import java.io.*;
import java.net.*;

public class Broker {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server");
    BufferedReader in = null;
    PrintWriter    out= null;

    ServerSocket servers = null;
    Socket       fromclient = null;

    // creare server socket
    try {
      servers = new ServerSocket(9090);
    } catch (IOException e) {
      System.out.println("Couldn't li0sten to port 9090");
      System.exit(-1);
    }

    try {
      System.out.print("Waiting for a client...");
      fromclient= servers.accept();
      System.out.println("Client connected");
    } catch (IOException e) {
      System.out.println("Can't accept");
      System.exit(-1);
    }

    in  = new BufferedReader(new 
     InputStreamReader(fromclient.getInputStream()));
    out = new PrintWriter(fromclient.getOutputStream(),true);
    String input;
    

    System.out.println("Wait for messagess");
    while ((input = in.readLine()) != null) {
     if (input.equalsIgnoreCase("exit")) break;
     out.println("S ::: "+input);
     System.out.println(input);
    }
    out.close();
    in.close();
    fromclient.close();
    servers.close();
  }
}
