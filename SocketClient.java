import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient{
	public static void main(String [] args) throws IOException{
		Socket socket = new Socket("localhost", 9990);
		// Only Wait server message coming ~
		//=================================
		// InputStreamReader input_data = new InputStreamReader(socket.getInputStream());
		// BufferedReader input = new BufferedReader(input_data);
		// String answer = input.readLine();
		// System.out.println("Received:"+ answer);
		// Only Send message to the socket server ~
		//=================================
		try{
			PrintWriter output_data = new PrintWriter(socket.getOutputStream(), true);
			output_data.println("Say hello to socket server~");
		}finally{
			socket.close();
		}	
	}

}
