package com.velan.reg.serviceimpl;

import com.velan.reg.model.Booking;
import com.velan.reg.repository.BookingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
class BookingServiceImpTest {

    @Mock
    private BookingRepo repo;

    @InjectMocks
    private BookingServiceImp bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBooking() {
        Booking booking = new Booking();
        doNothing().when(repo).add(booking);

        bookingService.addBooking(booking);

        verify(repo, times(1)).add(booking);
    }

    @Test
    void testGetBooking() {
        int id = 1;
        Booking booking = new Booking();
        when(repo.findById(id)).thenReturn(booking);

        Booking result = bookingService.getBooking(id);

        assertEquals(booking, result);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void testGetAllBookings() {
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        List<Booking> bookings = Arrays.asList(booking1, booking2);
        when(repo.findAllBookings()).thenReturn(bookings);

        List<Booking> result = bookingService.getAllBookings();

        assertEquals(bookings, result);
        verify(repo, times(1)).findAllBookings();
    }

    @Test
    void testUpdateBooking() {
        Booking booking = new Booking();
        doNothing().when(repo).update(booking);

        bookingService.updateBooking(booking);

        verify(repo, times(1)).update(booking);
    }

    @Test
    void testDeleteBooking() {
        int id = 1;
        doNothing().when(repo).delete(id);

        bookingService.deleteBooking(id);

        verify(repo, times(1)).delete(id);
    }

    @Test
    void testFindByOrganizerName() {
        String name = "John Doe";
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        List<Booking> bookings = Arrays.asList(booking1, booking2);
        when(repo.findByOrganizerName(name)).thenReturn(bookings);

        List<Booking> result = bookingService.findByOrganizerName(name);

        assertEquals(bookings, result);
        verify(repo, times(1)).findByOrganizerName(name);
    }

    @Test
    void testFindByExhibitorName() {
        String name = "Acme Corp";
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        List<Booking> bookings = Arrays.asList(booking1, booking2);
        when(repo.findByExhibitorName(name)).thenReturn(bookings);

        List<Booking> result = bookingService.findByExhibitorName(name);

        assertEquals(bookings, result);
        verify(repo, times(1)).findByExhibitorName(name);
    }
}
