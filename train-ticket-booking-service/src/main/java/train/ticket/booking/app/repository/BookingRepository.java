package train.ticket.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import train.ticket.booking.app.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
