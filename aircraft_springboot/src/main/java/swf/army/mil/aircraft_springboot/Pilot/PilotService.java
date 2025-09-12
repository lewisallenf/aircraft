package swf.army.mil.aircraft_springboot.Pilot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {
    private final PilotRepository pilotRepository;

    public PilotService(PilotRepository pilotRepository){
        this.pilotRepository = pilotRepository;
    }

    public Pilot savePilot(Pilot pilot){
        return pilotRepository.save(pilot);
    }

    public List<Pilot> findAllPilot(){
        return pilotRepository.findAll();
    }
}
