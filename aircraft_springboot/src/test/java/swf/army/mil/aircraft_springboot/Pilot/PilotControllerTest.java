package swf.army.mil.aircraft_springboot.Pilot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PilotController.class)
@AutoConfigureMockMvc
public class PilotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    PilotService pilotService;

    Pilot pilot1 = new Pilot(1L, "joseph", "horhe", 24);
    Pilot pilot2 = new Pilot(2L, "gerald", "Millamos", 22);
    ArrayList<Pilot> pilot = new ArrayList<>(List.of(pilot1, pilot2));

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreatePilots() throws Exception {
        Mockito.when(pilotService.savePilot(any(Pilot.class))).thenReturn(pilot1);
        String pilot1Json = objectMapper.writeValueAsString(pilot1);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/pilot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pilot1Json))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fname").value("joseph"))
                .andExpect(jsonPath("$.lname").value("horhe"))
                .andExpect(jsonPath("$.age").value(24));
        Mockito.verify(pilotService).savePilot(any(Pilot.class));
    }

    @Test
    void shouldGetAllPilot() throws Exception {
        Mockito.when(pilotService.findAllPilot()).thenReturn(pilot);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/pilot"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }
}

//    @Test
//    void shouldGetPilotById() throws Exception{
//        Mockito.when(pilotService.findPilotById(1L)).thenReturn(pilot1);
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api.pilot/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1));
//    }

