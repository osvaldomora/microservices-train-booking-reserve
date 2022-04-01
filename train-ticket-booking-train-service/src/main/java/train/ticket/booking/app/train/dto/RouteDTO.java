package train.ticket.booking.app.train.dto;

public class RouteDTO {
	private String source;
	private String destination;
	public RouteDTO(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}	
}
