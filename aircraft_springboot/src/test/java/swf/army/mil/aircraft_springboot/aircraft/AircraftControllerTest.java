package swf.army.mil.aircraft_springboot.aircraft;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.matcher.ElementMatchers.isArray;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AircraftController.class)
@AutoConfigureMockMvc
public class AircraftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    AircraftService aircraftService;

    Aircraft doghouse = new Aircraft(1L, "doghouse", null);
    Aircraft triplane = new Aircraft(2L, "triplane", null);
    ArrayList<Aircraft> aircraft = new ArrayList<>(List.of(doghouse, triplane));

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateAircraft() throws Exception{
        Mockito.when(aircraftService.saveAircraft(any(Aircraft.class))).thenReturn(doghouse);
        String doghouseJson = objectMapper.writeValueAsString(doghouse);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(doghouseJson))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.airframe").value("doghouse"))
                .andExpect(jsonPath("$.pilot").value("Snoopy"));
        Mockito.verify(aircraftService).saveAircraft(any(Aircraft.class));
    }

    @Test
    void shouldGetAllAircraft() throws Exception{
        Mockito.when(aircraftService.findAllAircraft()).thenReturn(aircraft);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/aircraft"))
                .andExpect(status().isOk())
                .andExpect(jsonPath( "$.*", hasSize(2)));
    }
//    @Test
//    void shouldGetAircraftById() throws Exception{
//        Mockito.when(aircraftService.findAircraftById(1L)).thenReturn(doghouse);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/aircraft/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1));
//    }

}
