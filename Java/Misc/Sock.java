import java.net.*;
import java.io.*;


public class Sock {

	static String  path = "";
	static String address = "";
	static Socket socket = null;
	static PrintWriter out  = null;
	static BufferedReader in = null;
	static int port  = 80;


	public static void main(String[] args) {
		
		parseURL(args[0]);

		try {
			socket = new Socket(InetAddress.getByName(address), port);
			out = new PrintWriter(socket.getOutputStream());
			out.println("GET /"+path+" HTTP/1.0");
			out.println();
			out.println("Host: " + address);
			out.println();
			out.flush();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response;
			boolean statusExtracted = false;
			String statuscode = "";
			while ((response = in.readLine()) != null) {
				if (!statusExtracted) {
					statuscode = response;
					statusExtracted = true;
					continue;
				}
				if ((response.split(" "))[0].equals("<!DOCTYPE") || (response.split(" "))[0].equals("<!doctype")) {
					break;
				}
				System.out.println(response);
			}
			System.out.println();
			System.out.println("The status code is : "+(statuscode.split(" "))[1]);
			in.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Please make sure the input to this class is an arg of form \"http://badunetworks.com/about\"");
		}


	}


	public static void parseURL(String arg) {

		try {
			String[] argvar;
			argvar = arg.split("//");
			argvar = argvar[1].split("/");
			address = argvar[0];
			try {
				path = argvar[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				path = "";
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Please make sure the input to this class is an arg of form \"http://badunetworks.com/about\"");
		}
	}
}