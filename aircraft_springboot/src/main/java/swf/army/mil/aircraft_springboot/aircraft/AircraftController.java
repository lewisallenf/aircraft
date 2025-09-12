package swf.army.mil.aircraft_springboot.aircraft;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService){
        this.aircraftService = aircraftService;
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft){
        return aircraftService.saveAircraft(aircraft);
    }
    @GetMapping
    public List<Aircraft> getAircraft(){
        return aircraftService.findAllAircraft();
    }
    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id){
        return aircraftService.findAircraftById(id);    }
}
