import java.io.*;
import java.net.*;

public class SessionThread implements Runnable{
	private Socket clientSocket;
	
	public SessionThread(Socket socket) {
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {
		
	}
}
