package train.ticket.booking.app.dto.client.train;

import java.io.Serializable;



public class TrainDto implements Serializable {
	


    private String trainId;
    private String model;
    private RouteDto route;
    private SeatDto seat;
    private final static long serialVersionUID = 2504300653763754526L;

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

    public SeatDto getSeat() {
        return seat;
    }

    public void setSeat(SeatDto seat) {
        this.seat = seat;
    }



}
