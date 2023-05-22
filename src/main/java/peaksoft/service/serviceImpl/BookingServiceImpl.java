package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Booking;
import peaksoft.repository.BookingRepository;
import peaksoft.service.BookingService;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }
    @Override
    public void saveBooking(Booking booking) {
    bookingRepository.saveBooking(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.getAllBooking();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.getBookingById(id);
    }

    @Override
    public void updateBookingById(Long id, Booking booking) {
  bookingRepository.updateBookingById(id,booking);
    }

    @Override
    public void deleteBookingById(Long id) {
  bookingRepository.deleteBookingById(id);
    }
}
