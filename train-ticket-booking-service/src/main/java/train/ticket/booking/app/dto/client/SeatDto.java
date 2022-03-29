
package train.ticket.booking.app.dto.client;

import java.io.Serializable;


public class SeatDto implements Serializable
{

    private String number;
    private String row;
    private final static long serialVersionUID = -5079141697556060340L;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

}
