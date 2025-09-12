package swf.army.mil.aircraft_springboot.aircraft;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AircraftService {
    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public Aircraft saveAircraft(Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    public List<Aircraft> findAllAircraft(){
      return aircraftRepository.findAll();
    }

    public Aircraft findAircraftById(Long id) {
       return aircraftRepository.findById(id).get();
    }
}
