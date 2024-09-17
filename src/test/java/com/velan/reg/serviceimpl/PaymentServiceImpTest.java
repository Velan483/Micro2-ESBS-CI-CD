package com.velan.reg.serviceimpl;

import com.velan.reg.model.Payment;
import com.velan.reg.repository.PaymentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
class PaymentServiceImpTest {

    @Mock
    private PaymentRepo repo;

    @InjectMocks
    private PaymentServiceImp paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPayment() {
        Payment payment = new Payment();
        doNothing().when(repo).add(payment);

        paymentService.addPayment(payment);

        verify(repo, times(1)).add(payment);
    }

    @Test
    void testGetAllPayments() {
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        List<Payment> payments = Arrays.asList(payment1, payment2);
        when(repo.findAllPayments()).thenReturn(payments);

        List<Payment> result = paymentService.getAllPayments();

        assertEquals(payments, result);
        verify(repo, times(1)).findAllPayments();
    }

    @Test
    void testDeleteBooking() {
        int id = 1;
        doNothing().when(repo).delete(id);

        paymentService.deleteBooking(id);

        verify(repo, times(1)).delete(id);
    }

    @Test
    void testFindByExhibitorName() {
        String name = "ExhibitorName";
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        List<Payment> payments = Arrays.asList(payment1, payment2);
        when(repo.findByExhibitorName(name)).thenReturn(payments);

        List<Payment> result = paymentService.findByExhibitorName(name);

        assertEquals(payments, result);
        verify(repo, times(1)).findByExhibitorName(name);
    }

    @Test
    void testFindByOrganizerName() {
        String name = "OrganizerName";
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        List<Payment> payments = Arrays.asList(payment1, payment2);
        when(repo.findByOrganizerName(name)).thenReturn(payments);

        List<Payment> result = paymentService.findByOrganizerName(name);

        assertEquals(payments, result);
        verify(repo, times(1)).findByOrganizerName(name);
    }
}
