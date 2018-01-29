import java.net.*;
import java.io.*;
import java.util.*;
class Client
{
	public static void main(String[] args) throws Exception{
		
		String ip = "localhost";
		Scanner sc = new Scanner(System.in);
		
		Socket conn = new Socket(ip, 6666);
		String str;
		String str2;
		ObjectOutputStream output;
		ObjectInputStream input;

			output = new ObjectOutputStream(conn.getOutputStream());
			input = new ObjectInputStream(conn.getInputStream());
		
		do{
			System.out.print("CLIENT - ");
			str = sc.nextLine();
			
			output.writeObject(str);
			output.flush();

			str2 = (String)input.readObject();
			System.out.println("SERVER - " + str2);

		}while(!str.equals("END") && !str2.equals("END"));


		input.close();
		output.close();
		conn.close();

	}
}