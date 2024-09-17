package com.velan.reg.serviceimpl;

import com.velan.reg.model.Organizer;
import com.velan.reg.repository.OrganizerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
class OrganizerServiceImpTest {

    @Mock
    private OrganizerRepo repo;

    @Mock
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @InjectMocks
    private OrganizerServiceImp organizerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByEmail() {
        String email = "test@example.com";
        Organizer organizer = new Organizer();
        when(repo.findByEmail(email)).thenReturn(organizer);

        Organizer result = organizerService.findByEmail(email);

        assertEquals(organizer, result);
        verify(repo, times(1)).findByEmail(email);
    }

    @Test
    void testGetOrganizer() {
        int id = 1;
        Organizer organizer = new Organizer();
        when(repo.findById(id)).thenReturn(organizer);

        Organizer result = organizerService.getOrganizer(id);

        assertEquals(organizer, result);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void testGetAllOrganizers() {
        Organizer organizer1 = new Organizer();
        Organizer organizer2 = new Organizer();
        List<Organizer> organizers = Arrays.asList(organizer1, organizer2);
        when(repo.findAllOrganizers()).thenReturn(organizers);

        List<Organizer> result = organizerService.getAllOrganizers();

        assertEquals(organizers, result);
        verify(repo, times(1)).findAllOrganizers();
    }

    @Test
    void testUpdateOrganizer() {
        Organizer organizer = new Organizer();
        doNothing().when(repo).update(organizer);

        organizerService.updateOrganizer(organizer);

        verify(repo, times(1)).update(organizer);
    }

    @Test
    void testDeleteOrganizer() {
        int id = 1;
        doNothing().when(repo).delete(id);

        organizerService.deleteOrganizer(id);

        verify(repo, times(1)).delete(id);
    }

    @Test
    void testUpdateProfilePhoto() throws IOException {
        int organizerId = 1;
        Organizer organizer = new Organizer();
        MultipartFile file = mock(MultipartFile.class);
        byte[] imageBytes = new byte[]{1, 2, 3};

        when(repo.findById(organizerId)).thenReturn(organizer);
        when(file.getBytes()).thenReturn(imageBytes);
        doNothing().when(repo).add(organizer);

        String result = organizerService.updateProfilePhoto(organizerId, file);

        assertEquals("http://localhost:8090/organizer/photos/" + organizerId, result);
        assertArrayEquals(imageBytes, organizer.getProfileImage());
        verify(repo, times(1)).add(organizer);
    }
}
