package swf.army.mil.aircraft_springboot.aircraft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AircraftServiceTest {
    @Mock
    AircraftRepository aircraftRepository;

    @InjectMocks
    AircraftService aircraftService;
    Aircraft doghouse = new Aircraft(1L, "doghouse",null);
    List<Aircraft> flight;

    @BeforeEach
    void setUp(){
        flight = new ArrayList<>(List.of(doghouse));
    }

    @Test
    void shouldSaveAircraft(){
        // Arrange
        when(aircraftRepository.save(doghouse)).thenReturn(doghouse);
        // Act
        Aircraft actualAircraft =  aircraftService.saveAircraft(doghouse);
        // Assert
        verify (aircraftRepository, times(1)).save(any(Aircraft.class));
        assertThat(actualAircraft).isEqualTo(doghouse);
    }

    @Test
    void shouldFindAllAircraft(){
        //Arrange
        when(aircraftRepository.findAll()).thenReturn(flight);
        //Act
        List<Aircraft> listAllAircraft = aircraftService.findAllAircraft();
        //Assert
        verify(aircraftRepository, times(1)).findAll();
        assertThat(listAllAircraft).isEqualTo(flight);
    }

    @Test
    void shouldFindById(){
        //Arrage
        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(doghouse));
        //Act
        Aircraft foundSingleAircraft = aircraftService.findAircraftById(1L);
        //Assert
        verify(aircraftRepository, times(1)).findById(1L);
        assertThat(foundSingleAircraft).isEqualTo(doghouse);
    }
}
