package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Booking;
import peaksoft.exception.MyException;
import peaksoft.repository.BookingRepository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;
    @Autowired
    public BookingRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public void saveBooking(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> bookings = entityManager.createQuery("select b from Booking b",Booking.class).getResultList();
        return bookings;
    }

    @Override
    public Booking getBookingById(Long id) {
        try {
            boolean is = false;
            for (Booking b:getAllBooking()) {
                if (Objects.equals(b.getId(),id)){
                    is = true;
                }
            }
            if (is){
                return entityManager.createQuery("select b from Booking b where b.id=id",Booking.class).setParameter("id",id).getSingleResult();
            }else {
                throw new MyException(id + " not found");
            }
        }catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateBookingById(Long id, Booking booking) {
        Booking booking1 = entityManager.find(Booking.class,id);
        booking1.setId(booking.getId());
        entityManager.merge(booking1);
    }

    @Override
    public void deleteBookingById(Long id) {

    }
}
