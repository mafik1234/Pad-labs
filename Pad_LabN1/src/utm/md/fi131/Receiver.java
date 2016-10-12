package utm.md.fi131;

import java.io.*;
import java.net.*;
import java.util.Random;
import com.google.gson.Gson;
public class Receiver {
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
           Mesaj mes = new Mesaj("read","");
           Gson gson = new Gson();
           String jmes=gson.toJson(mes);
    	   out.println(jmes);
           String	 input = in.readLine();
            if (input!=null){
                System.out.println(input);
               }
    	    fromserver.close();
      Thread.sleep(100);
          }
        }
     }
