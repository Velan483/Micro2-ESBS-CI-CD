package com.velan.reg.serviceimpl;

import com.velan.reg.model.Exhibition;
import com.velan.reg.repository.ExhibitionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExhibitionServiceImpTest {

    @Mock
    private ExhibitionRepo repo;

    @InjectMocks
    private ExhibitionServiceImp exhibitionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetExhibition() {
        int id = 1;
        Exhibition exhibition = new Exhibition();
        when(repo.findById(id)).thenReturn(exhibition);

        Exhibition result = exhibitionService.getExhibition(id);

        assertEquals(exhibition, result);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void testGetAllExhibitions() {
        Exhibition exhibition1 = new Exhibition();
        Exhibition exhibition2 = new Exhibition();
        List<Exhibition> exhibitions = Arrays.asList(exhibition1, exhibition2);
        when(repo.findAllExhibitions()).thenReturn(exhibitions);

        List<Exhibition> result = exhibitionService.getAllExhibitions();

        assertEquals(exhibitions, result);
        verify(repo, times(1)).findAllExhibitions();
    }

    @Test
    void testUpdateExhibition() {
        Exhibition exhibition = new Exhibition();
        doNothing().when(repo).update(exhibition);

        exhibitionService.updateExhibition(exhibition);

        verify(repo, times(1)).update(exhibition);
    }

    @Test
    void testDeleteExhibition() {
        int id = 1;
        doNothing().when(repo).delete(id);

        exhibitionService.deleteExhibition(id);

        verify(repo, times(1)).delete(id);
    }
}
