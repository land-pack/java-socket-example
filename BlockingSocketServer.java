// package tcp;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWrite;
// import java.io.PrintWriter;
// import java.net.ServerSocket;
// import java.net.Socket;
import java.io.*;
import java.net.*;

public class BlockingSocketServer {
	public static int port = 9990;
	public static void main(String args[]) throws IOException{
		ServerSocket socket_instance = new ServerSocket(port);
		System.out.println("Socket Instance:" + socket_instance);

		// Accept client connection !
		Socket socket = socket_instance.accept();
		try{
			System.out.println("Accept the client:" + socket);
			BufferedReader client_data = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter buf_writer = new BufferedWriter(osw);
			PrintWriter out = new PrintWriter(buf_writer, true);
			while(true){
				String str = client_data.readLine();
				if (str.equals("quit")){
					break;
				}
				System.out.println("Received from client:" + str);
				out.println();
			}
		}finally{
			System.out.println("Closed socket connection");
			socket.close();
			socket_instance.close();
		}
	}
}