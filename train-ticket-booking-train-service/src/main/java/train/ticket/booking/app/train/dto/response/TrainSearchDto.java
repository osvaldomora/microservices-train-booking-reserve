package train.ticket.booking.app.train.dto.response;

public class TrainSearchDto {
	private String capacity;
	private String model;
	
	public TrainSearchDto(String capacity, String model) {
		super();
		this.capacity = capacity;
		this.model = model;
	}
	public TrainSearchDto() {
		
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
