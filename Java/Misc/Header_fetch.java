//Author: @joelbandi
//visit me: http://www.joelbandi.me/

//Description
//Sends a get request to a webpage and prtins the header and the status code to the terminal


import java.net.*;
import java.io.*;
import java.util.*;


public class Header_fetch {

	public static void main(String[] args) {

		try {

			URL url = new URL(args[0]);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			Map<String, List<String>> map = connection.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				if (!(entry.getKey() == null)) {
					System.out.println("Header: " + entry.getKey() + " ,Value : " + entry.getValue());
				}
			}
			System.out.println("\n \n Status code is " + connection.getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}