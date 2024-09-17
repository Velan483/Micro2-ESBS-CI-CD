package com.velan.reg.serviceimpl;

import com.velan.reg.model.Exhibitor;
import com.velan.reg.repository.ExhibitorRepo;
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
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
class ExhibitorServiceImpTest {

    @Mock
    private ExhibitorRepo repo;

    @Mock
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @InjectMocks
    private ExhibitorServiceImp exhibitorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByEmail() {
        String email = "test@example.com";
        Exhibitor exhibitor = new Exhibitor();
        when(repo.findByEmail(email)).thenReturn(exhibitor);

        Exhibitor result = exhibitorService.findByEmail(email);

        assertEquals(exhibitor, result);
        verify(repo, times(1)).findByEmail(email);
    }

    @Test
    void testGetExhibitor() {
        int id = 1;
        Exhibitor exhibitor = new Exhibitor();
        when(repo.findById(id)).thenReturn(exhibitor);

        Exhibitor result = exhibitorService.getExhibitor(id);

        assertEquals(exhibitor, result);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void testGetAllExhibitors() {
        Exhibitor exhibitor1 = new Exhibitor();
        Exhibitor exhibitor2 = new Exhibitor();
        List<Exhibitor> exhibitors = Arrays.asList(exhibitor1, exhibitor2);
        when(repo.findAllExhibitors()).thenReturn(exhibitors);

        List<Exhibitor> result = exhibitorService.getAllExhibitors();

        assertEquals(exhibitors, result);
        verify(repo, times(1)).findAllExhibitors();
    }

    @Test
    void testUpdateExhibitor() {
        Exhibitor exhibitor = new Exhibitor();
        doNothing().when(repo).update(exhibitor);

        exhibitorService.updateExhibitor(exhibitor);

        verify(repo, times(1)).update(exhibitor);
    }

    @Test
    void testDeleteExhibitor() {
        int id = 1;
        doNothing().when(repo).delete(id);

        exhibitorService.deleteExhibitor(id);

        verify(repo, times(1)).delete(id);
    }

    @Test
    void testUpdateProfilePhoto() throws IOException {
        int exhibitorId = 1;
        Exhibitor exhibitor = new Exhibitor();
        MultipartFile file = mock(MultipartFile.class);
        byte[] imageBytes = new byte[]{1, 2, 3};

        when(repo.findById(exhibitorId)).thenReturn(exhibitor);
        when(file.getBytes()).thenReturn(imageBytes);
        doNothing().when(repo).add(exhibitor);

        String result = exhibitorService.updateProfilePhoto(exhibitorId, file);

        assertEquals("http://localhost:8090/exhibitor/photos/" + exhibitorId, result);
        assertArrayEquals(imageBytes, exhibitor.getProfileImage());
        verify(repo, times(1)).add(exhibitor);
    }
}
