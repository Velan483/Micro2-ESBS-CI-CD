package com.velan.reg.serviceimpl;

import com.velan.reg.model.Stall;
import com.velan.reg.repository.StallRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
class StallServiceImpTest {

    @Mock
    private StallRepo repo;

    @InjectMocks
    private StallServiceImp stallService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddStall() {
        Stall stall = new Stall();
        doNothing().when(repo).add(stall);

        stallService.addStall(stall);

        verify(repo, times(1)).add(stall);
    }

    @Test
    void testGetStall() {
        int id = 1;
        Stall stall = new Stall();
        when(repo.findById(id)).thenReturn(stall);

        Stall result = stallService.getStall(id);

        assertEquals(stall, result);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void testGetAllStalls() {
        Stall stall1 = new Stall();
        Stall stall2 = new Stall();
        List<Stall> stalls = Arrays.asList(stall1, stall2);
        when(repo.findAllStalls()).thenReturn(stalls);

        List<Stall> result = stallService.getAllStalls();

        assertEquals(stalls, result);
        verify(repo, times(1)).findAllStalls();
    }

    @Test
    void testUpdateStall() {
        Stall stall = new Stall();
        doNothing().when(repo).update(stall);

        stallService.updateStall(stall);

        verify(repo, times(1)).update(stall);
    }

    @Test
    void testDeleteStall() {
        int id = 1;
        doNothing().when(repo).delete(id);

        stallService.deleteStall(id);

        verify(repo, times(1)).delete(id);
    }

    @Test
    void testFindByOrganizerName() {
        String name = "OrganizerName";
        Stall stall1 = new Stall();
        Stall stall2 = new Stall();
        List<Stall> stalls = Arrays.asList(stall1, stall2);
        when(repo.findByOrganizerName(name)).thenReturn(stalls);

        List<Stall> result = stallService.findByOrganizerName(name);

        assertEquals(stalls, result);
        verify(repo, times(1)).findByOrganizerName(name);
    }

    @Test
    void testFindByEventVenue() {
        String eventVenue = "EventVenue";
        Stall stall1 = new Stall();
        Stall stall2 = new Stall();
        List<Stall> stalls = Arrays.asList(stall1, stall2);
        when(repo.findByEventVenue(eventVenue)).thenReturn(stalls);

        List<Stall> result = stallService.findByEventVenue(eventVenue);

        assertEquals(stalls, result);
        verify(repo, times(1)).findByEventVenue(eventVenue);
    }

    @Test
    void testFindByEventName() {
        String eventName = "EventName";
        Stall stall = new Stall();
        when(repo.findByEventName(eventName)).thenReturn(stall);

        Stall result = stallService.findByEventName(eventName);

        assertEquals(stall, result);
        verify(repo, times(1)).findByEventName(eventName);
    }

    @Test
    void testUpdateAvailableStall() {
        int stallId = 1;
        int availableStall = 5;
        Stall stall = new Stall();
        when(repo.findById(stallId)).thenReturn(stall);
        doNothing().when(repo).update(stall);

        boolean result = stallService.updateAvailableStall(stallId, availableStall);

        assertTrue(result);
        assertEquals(availableStall, stall.getAvailableStall());
        verify(repo, times(1)).update(stall);
    }

    @Test
    void testUpdateAvailableStallNotFound() {
        int stallId = 1;
        int availableStall = 5;
        when(repo.findById(stallId)).thenReturn(null);

        boolean result = stallService.updateAvailableStall(stallId, availableStall);

        assertFalse(result);
        verify(repo, times(0)).update(any(Stall.class));
    }
}
