package hong.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerV2 {

	public static int port = 8888;
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("serverSocket start socket:"+ serverSocket);
		//waiting for connection 
		Socket socket = serverSocket.accept();
		try {
			System.out.println("connection accept socket:"+socket);
			//Receive request
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//return info 
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			String str = "";
			Scanner input = new Scanner(System.in);
			String strs = "";
			while(!str.equals("end")){
				str =  br.readLine();
				if(str.equals("end")){
					break;
				}
				System.out.println("Client Message:"+str);
				System.out.println("Message:");
				strs = input.nextLine();
				pw.println(strs);
				pw.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("Close..........");
				socket.close();
				serverSocket.close();
		}
	}

}
