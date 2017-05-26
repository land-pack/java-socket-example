package hong.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class SocketClientV2 {

	public static void main(String[] args) throws IOException {
		Socket socket = null;  
        BufferedReader br = null;  
        PrintWriter pw = null;  
        try {  
            //Client socket  
            socket = new Socket("localhost", 8888);  
            System.out.println("Socket=" + socket);  
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(  
            		socket.getOutputStream())),true);  
            br = new BufferedReader(new InputStreamReader(  
                    socket.getInputStream()));  
            Scanner input = new Scanner(System.in);
            String info=null;
            while(true){
                System.out.println("Message:");
                info = input.nextLine();
                if ("end".equals(info)){
					pw.println("end");
					break;
				}
				pw.println(info);
				System.out.println("Server Message:" + br.readLine());
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                System.out.println("close......");  
                socket.close();  
        }  
    }  

}
