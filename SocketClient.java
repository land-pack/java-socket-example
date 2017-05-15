import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient{
	public static void main(String [] args) throws IOException{
		Socket socket = new Socket("localhost", 9998);
		// Only Wait server message coming ~
		//=================================
//		 InputStreamReader input_data = new InputStreamReader(socket.getInputStream());
//		 BufferedReader input = new BufferedReader(input_data);
//		 String answer = input.readLine();
//		 System.out.println("Received:"+ answer);
//		 Only Send message to the socket server ~
		//=================================
		try{
			PrintWriter output_data = new PrintWriter(socket.getOutputStream(), true);
			Scanner input = new Scanner(System.in);
			String info = null;
			while (true){
				System.out.print("Please enter something:");
				info = input.nextLine();
				if ("quit".equals(info)){
					output_data.println("quit");
					break;
				}
				output_data.println(info);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			socket.close();
		}
	}

}
