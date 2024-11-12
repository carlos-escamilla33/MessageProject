import java.io.*;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.List;


public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("ServerSocket awaiting connections...");
		
		Socket socket = ss.accept();
		System.out.println("Connection from " + socket + "!");
		
		InputStream inputStream = socket.getInputStream();
		
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		
		List<Message> listOfMessages = (List<Message>) ObjectInputStream.readObject();
		System.out.println("Recieved [" + listOfMessages.size() + "] messages from: " + socket);
		
		System.out.println("All messages: ");
		listOfMessages.forEach(msg -> printMessage(msg));
		
		System.out.println("Closing sockets.");
		ss.close();
		socket.close();
	}
	
	private static void printMessage(Message msg) {
		System.out.println("ID: " + msg.getId());
		System.out.println("Satus: " + msg.getStatus());
		System.out.println("Type: " + msg.getType());
		System.out.println("Text: " + msg.getText());
	}

}


























