
package train.ticket.booking.app.dto.client.train;

import java.io.Serializable;


public class RouteDto implements Serializable
{

    private String routeId;
    private String departureDate;
    private String destination;
    private String source;
    private String price;
    private  static final long serialVersionUID = -5353745690337922637L;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
