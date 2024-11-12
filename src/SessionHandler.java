import java.io.*;
import java.net.*;

public class SessionHandler implements Runnable{
	private Socket clientSocket;
	private String connectionStatus = "Failed";
	
	public SessionHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {
		try (
				ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
			) {
			
			Object recievedObj = input.readObject();
			Message message = (Message) recievedObj;
			
			if (message.getType().equals("login")) {
				this.connectionStatus = "Success";
				
				output.writeObject(connectionStatus);
				output.flush();
				
				while (message.getType().equals("login")) {
					
				}
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
