package train.ticket.booking.app.train.dto;

import train.ticket.booking.app.train.entity.Route;

public class TrainDetails {
	
	private String model;
	private String capacity;
	private Route routeDto;
	
	public TrainDetails(String model, String capacity, Route routeDto) {
		super();
		this.model = model;
		this.capacity = capacity;
		this.routeDto = routeDto;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Route getRouteDto() {
		return routeDto;
	}
	public void setRouteDto(Route routeDto) {
		this.routeDto = routeDto;
	}

	
}
