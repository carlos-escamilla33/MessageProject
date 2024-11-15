import java.io.*;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.List;

public class Server {
	private static final int PORT = 7777;

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server listening on port " + PORT);
			
			while (true) {
				Socket clientSocket = serverSocket.accept();
				
				System.out.println("New client connected...");
				
				// start a new connection for each client
				SessionHandler sessionHandler = new SessionHandler(clientSocket);
				new Thread(sessionHandler).start();
			}
			
		
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}


























