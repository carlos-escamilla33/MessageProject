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
				
				
				if (lastMsg.getType().equals("login")) {
					lastMsg.setStatus("success");
					
					output.writeObject(lastMsg.getStatus());
					output.flush();
					
					if (lastMsg.getType().equals("text")) {
						lastMsg.setText(lastMsg.getText().toUpperCase());
						
						output.writeObject(lastMsg.getText());
						output.flush();
					}
					
				} else {
					output.writeObject("success");
					output.flush();
					output.writeObject("logging out");
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


























