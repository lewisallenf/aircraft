package swf.army.mil.aircraft_springboot.Pilot;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PilotServiceTest {

    @Mock
    PilotRepository pilotRepository;

    @InjectMocks
    PilotService pilotService;
    Pilot pilot1 = new Pilot( 1L, "joseph", "horhe", 24);
    List<Pilot> paxs;

    @BeforeEach
    void setUp(){
        paxs = new ArrayList<>(List.of(pilot1));
    }

    @Test
    void shouldSavePilot(){
        when(pilotRepository.save(pilot1)).thenReturn(pilot1);
        Pilot actualPilot = pilotService.savePilot(pilot1);
        verify(pilotRepository, times(1)).save(any(Pilot.class));
        assertThat(actualPilot).isEqualTo(pilot1);
    }

    @Test
    void shouldFindAllPilot(){
        when(pilotRepository.findAll()).thenReturn(paxs);
        List<Pilot> listAllPilot = pilotService.findAllPilot();
        verify(pilotRepository, times(1)).findAll();
        assertThat(listAllPilot).isEqualTo(paxs);
    }



}
