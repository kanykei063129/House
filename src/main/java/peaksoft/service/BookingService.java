package peaksoft.service;

import peaksoft.entity.Booking;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingById(Long id);
    void updateBookingById(Long id,Booking booking);
    void deleteBookingById(Long id);
}
