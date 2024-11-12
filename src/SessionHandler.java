import java.io.*;
import java.net.*;

public class SessionHandler implements Runnable{
	private Socket clientSocket;
	
	public SessionHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {
		try ()
	}
}
