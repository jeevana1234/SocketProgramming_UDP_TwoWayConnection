// Server2 class that
// receives data and sends data

import java.io.*;
import java.net.*;
import java.util.*;
import java.time.*;
import java.util.concurrent.TimeUnit;

class Server {

	public static void main(String args[])
		throws Exception
	{
int slen=0,clen=0;
		// Create server Socket
		ServerSocket ss = new ServerSocket(888);

		// connect it to client socket
		Socket s = ss.accept();
		System.out.println("Connection established");
long startTime = System.nanoTime();


		// to send data to the client
		PrintStream ps
			= new PrintStream(s.getOutputStream());


		// to read data coming from the client

		BufferedReader br
			= new BufferedReader(
				new InputStreamReader(
					s.getInputStream()));

		// to read data from the keyboard
		BufferedReader kb
			= new BufferedReader(
				new InputStreamReader(System.in));

		// server executes continuously
		while (true) {

			String str, str1;
                           

			// repeat as long as the client
			// does not send a null string

			// read from client

			while ((str = br.readLine()) != null) {
				System.out.println("client message:"+str);
              clen=clen+str.length();          
				str1 = kb.readLine();
               slen=slen+str1.length();
				// send to client
				ps.println(str1);
                                     

			}
System.out.println("***********************************************");

double cbytes=clen;
double size_kb = cbytes /1024;
System.out.println("client data in kilobytes:"+size_kb);
double size_mb = size_kb / 1024;
System.out.println("client data in megabytes:"+size_mb);
		double size_gb = size_mb / 1024 ;
System.out.println("client data in gigabytes:"+size_gb);
 System.out.println("***********************************************");

double sbytes=slen;
double size_k = sbytes /1024;
System.out.println("server data in kilobytes:"+size_k);
double size_m= size_k/ 1024;
System.out.println("server data in megabytes:"+size_m);
		double size_g = size_m / 1024 ;
System.out.println("server data in gigabytes:"+size_g);
 
System.out.println("*************************************************");
long endTime = System.nanoTime();
long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
LocalDate myobj=LocalDate.now();
System.out.println("Date :"+myobj);
      LocalTime time = LocalTime.now();
      System.out.println("Current time: "+time);

System.out.println("**************************************************");

			// close connection
			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();

			// terminate application
			System.exit(0);

		} // end of while
	}
}
