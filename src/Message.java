import java.io.Serializable;

public class Message implements Serializable{
	private static int count = 0;
	private final int id;
	protected String type;
	protected String status;
	protected String text;
	
	public Message() {
		this.type = "Undefined";
		this.status = "Undefined";
		this.text = "Undefined";
		this.id = count ++;
	}
	
	public Message(String type, String status, String text) {
		this.type = type;
		this.status = status;
		this.text = text;
		this.id = count ++;
	}
	
	private void setType(String type) {
		if (this.type.equals("Undefined")) {
			this.type = type;
		}
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getId() {
		return this.id;
	}
	
	
}
