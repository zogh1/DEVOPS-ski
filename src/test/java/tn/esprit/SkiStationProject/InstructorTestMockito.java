package tn.esprit.SkiStationProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.SkiStationProject.repositories.InstructorRepository;
import tn.esprit.SkiStationProject.services.InstructorServicesImpl;
import tn.esprit.SkiStationProject.entities.Instructor;
import tn.esprit.SkiStationProject.repositories.InstructorRepository;


public class InstructorTestMockito {

    @InjectMocks
    InstructorServicesImpl InstructorServices;

    @Mock
    InstructorRepository InstructorRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllInstructors() {
        List<Instructor> Instructors = new ArrayList<>();
        // Add test data to the list

        when(InstructorRepository.findAll()).thenReturn(Instructors);

        List<Instructor> result = InstructorServices.retrieveAllInstructors();

        assertEquals(Instructors, result);
    }

    @Test
    public void testAddInstructor() {
        Instructor Instructor = new Instructor();
        // Set properties for the test activity sector

        when(InstructorRepository.save(Instructor)).thenReturn(Instructor);

        Instructor result = InstructorServices.addInstructor(Instructor);

        assertEquals(Instructor, result);
    }

@Test
public void testRetriveInstructor() {
    Long idToRetrieve = 1L;
    Instructor instructor = new Instructor();
    when(InstructorRepository.findById(idToRetrieve)).thenReturn(Optional.of(instructor));

    Instructor result = InstructorRepository.findById(idToRetrieve).orElse(null);

    assertEquals(instructor, result);
}


    @Test
    public void testUpdateInstructor() {
        Instructor Instructor = new Instructor();
        // Set properties for the test activity sector

        when(InstructorRepository.save(Instructor)).thenReturn(Instructor);

        Instructor result = InstructorServices.updateInstructor(Instructor);

        assertEquals(Instructor, result);
    }

    @Test
    public void testRetrieveInstructor() {
        Long idToRetrieve = 1L;
        Instructor Instructor = new Instructor();
        // Set properties for the test activity sector

        when(InstructorRepository.findById(idToRetrieve)).thenReturn(Optional.of(Instructor));

        Instructor result = InstructorServices.retrieveInstructor(idToRetrieve);

        assertEquals(Instructor, result);
    }

}
