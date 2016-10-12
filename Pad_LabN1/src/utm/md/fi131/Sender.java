package utm.md.fi131;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;
import com.google.gson.Gson;
public class Sender {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Welcome to Client");
    Socket fromserver = null;
    while (true) {
    	   fromserver = new Socket("localhost",4445);
    	   PrintWriter    out = new PrintWriter(fromserver.getOutputStream(),true);
           Mesaj mes = new Mesaj("send","");
           Gson gson = new Gson();
           String jmes;
        // Random randomGenerator = new Random();
	    //	int randomInt = randomGenerator.nextInt(100);
		   Scanner scanner = new Scanner(System.in);
		   String mymes=(scanner.next());
		   mes = new Mesaj("send",mymes);
		   jmes=gson.toJson(mes);
    	   out.println(jmes);
    	   fromserver.close();
    
                 }  
           }
         }
