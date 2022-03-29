package train.ticket.booking.app.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import train.ticket.booking.app.passenger.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
