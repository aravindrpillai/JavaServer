import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 

public class Server { 

	public static void main(String args[]) throws IOException { 
		int port = Integer.parseInt(args[0]);
		ServerSocket server = new ServerSocket(port); 
		System.out.println("Listening for connection on port "+port+" ...."); 
		while (true) { 
			try (Socket socket = server.accept()) { 
				System.out.println("Hit Happened at port : "+port);
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n <h1>Port open at : " + port+"</h1>"; 
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
			} 
		} 
	} 
}