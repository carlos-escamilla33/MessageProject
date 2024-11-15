import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SessionHandler implements Runnable{
	private Socket clientSocket;
	private ArrayList<Message> userMsgs;
	
	public SessionHandler(Socket socket) {
		this.clientSocket = socket;
		this.userMsgs = new ArrayList<Message>();
	}
	
	@Override
	public void run() {
		try (
				ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
			) {
			
			while (true) {
				Object recievedObj = input.readObject();
				Message message = (Message) recievedObj;
				
				userMsgs.add(message);
				
				Message lastMsg = userMsgs.get(userMsgs.size() - 1);
				
				
				if (lastMsg.getStatus().equals("login message")) {
					output.writeObject("success");
					
					output.writeObject(new Message("login", "text message", "Enter text."));
					output.flush();
					
				} else if (lastMsg.getStatus().equals("text message")) {
					String capText = lastMsg.getText().toUpperCase();
					
					output.writeObject(new Message("text", "text message", capText));
					output.flush();
				} else if (lastMsg.getType().equals("logout message")) {
					output.writeObject(new Message("logout", "logout message", "Logout successful!"));
                    output.flush();
                    break;
				}
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


























