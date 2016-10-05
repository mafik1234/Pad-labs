package utm.md.fi131;




import java.io.*;
import java.net.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.JSONException;
import org.json.JSONObject;

public class Broker {

  public static void main(String[] args) throws IOException, JSONException, InterruptedException {
	  Queue<String> queue = new ConcurrentLinkedQueue<String>();
    System.out.println("Welcome to Broker");
    BufferedReader in = null;
    PrintWriter    out= null;

    ServerSocket servers =new ServerSocket(4445);
  

 




      System.out.print("Waiting for a client...");
    while(true){
    	//System.out.println("While");
    	 
    	 Socket    fromclient= servers.accept();
      	
    	
     
  
    in  = new BufferedReader(new 
     InputStreamReader(fromclient.getInputStream()));
    
    out = new PrintWriter(fromclient.getOutputStream(),true);
    String input;
    
   
    input = in.readLine();

    
 
    JSONObject jObject  = new JSONObject(input); 
    String command = jObject.getString("command");

   if (command.equals("send"))
   {
	   queue.add(input);
	   System.out.println("measaj "+input);
   }
   else
   	if (command.equals("read")){
    
   		
   		  if(queue.isEmpty()==false){
   		out.println(queue.poll());
   		
   		  }
    
   	}
    
   
   //Thread.sleep(100);
   
  fromclient.close();

 
    
  
}
    
    
    } 
    
}