<<<<<<< HEAD
// this is the server file for chat application!!!   
=======
// this is the server file for chat application!!!
>>>>>>> 9ccd3b76f2337af0154af8e9b4717b4c9dd2398f
// this was added from the github

import java.net.*;
import java.io.*;
import java.util.*;

class Server
{
	public static void main(String[] args) throws Exception{
		
		ServerSocket ss = new ServerSocket(6666);
		Scanner sc = new Scanner(System.in);
		String str;
		String str2;
		ObjectOutputStream output;
		ObjectInputStream input;

		System.out.println("Waiting for Connection...");
		Socket conn = ss.accept();
		System.out.println("Connected. \n Type \"END\" to quit.");

			input = new ObjectInputStream(conn.getInputStream());
			output = new ObjectOutputStream(conn.getOutputStream());

		do{
			str = (String)input.readObject();
			System.out.println("CLIENT - " + str);

			System.out.print("SERVER - ");
			str2 = sc.nextLine();

			output.writeObject(str2);
			output.flush();

		}while(!str.equals("END") && !str2.equals("END"));


		sc.close();
		input.close();
		output.close();
		conn.close();

	}
}
