import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SessionHandler implements Runnable{
	private Socket clientSocket;
	private String connectionStatus = "unsuccessful";
	private ArrayList<String> userCommands = new ArrayList<String>();
	
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
				
				while (message.getType().equals("text")) {
					
				}
				
				if (message.getType().equals("logout")) {
					output.writeObject(connectionStatus);
					output.writeObject("Logout complete...");
					output.flush();
				}
				
				this.connectionStatus = "unsuccessful";
				
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if (clientSocket != null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing client socket: " + e.getMessage());
			}
		}
	}
}


























