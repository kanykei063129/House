package peaksoft.repository;

import peaksoft.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingById(Long id);
    void updateBookingById(Long id,Booking booking);
    void deleteBookingById(Long id);
}
