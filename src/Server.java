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
		
		
	}

}


























