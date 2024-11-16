import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("localhost", 7777)) {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Scanner scanner = new Scanner(System.in);
			
			Message currMsg = new Message("login", "login message", "attempting to login");
			output.writeObject(currMsg);
			output.flush();
			
			while (true) {
				Object serverRes = input.readObject();
				Message messageServer = (Message) serverRes;
				System.out.println("server response: " + messageServer.getText());
			
				
				if (messageServer.getStatus().equals("text message")) {
					System.out.println("Enter your message: ");
					String text = scanner.nextLine();
					output.writeObject(new Message("login", "text message", text));
					output.flush();
				} else if (messageServer.getStatus().equals("logout message")) {
					break;
				}
				
				
			}
			
			scanner.close();
			
		} catch (IOException e) {
			e.getStackTrace();
		} 
	}

}
