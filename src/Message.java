import java.io.Serializable;

public class Message {
	
	protected String type;
	protected String status;
	protected String text;
	
	public Message() {
		this.type = "Undefined";
		this.status = "Undefined";
		this.text = "Undefined";
	}
	
	public Message(String type, String status, String text) {
		this.type = setType(type);
		this.status = setStatus(status);
		this.text = setText(text);
	}
	
	private void setType(String type) {
		
	}
	
	private void setStatus(String status) {
		
	}
	
	private void setText(String text) {
		
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
	
	
}
