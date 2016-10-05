package utm.md.fi131;

import java.io.*;
import java.net.*;
import java.util.Random;

import com.google.gson.Gson;

public class Sender {
  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println("Welcome to Client");

    Socket fromserver = null;

 
    while (true) {

    	   fromserver = new Socket("localhost",4445);
    BufferedReader in  = new
     BufferedReader(new 
      InputStreamReader(fromserver.getInputStream()));
   
    PrintWriter    out = new 
     PrintWriter(fromserver.getOutputStream(),true);
   
 

 
    Mesaj mes = new Mesaj("send","Victor");
    Gson gson = new Gson();
    String jmes=gson.toJson(mes);
   
      Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
		mes = new Mesaj("send","mess--"+randomInt);
		  
		 jmes=gson.toJson(mes);
    	out.println(jmes);
    	fromserver.close();
      Thread.sleep(1000);
    }

  
    
  }
}
