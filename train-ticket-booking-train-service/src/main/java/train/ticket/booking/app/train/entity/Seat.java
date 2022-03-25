package train.ticket.booking.app.train.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	private Integer seatId;
	 @Column(name="valueRow") 
	private Integer row;
	 @Column(name="valueNumber") 
	private Integer number;
	
	@ManyToOne
	private Train train;

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train trainid) {
		this.train = trainid;
	}
	
	
	
	
	
}
