package swf.army.mil.aircraft_springboot.aircraft;

import jakarta.persistence.*;
import swf.army.mil.aircraft_springboot.Pilot.Pilot;

@Entity
public class Aircraft{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airframe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;



    public void setId(Long id) {this.id = id;}
    public void setPilot(Pilot pilot) {this.pilot = pilot;}
    public void setAirframe(String airframe) {this.airframe = airframe;}

    public Long getId() {return id;}
    public Pilot getPilot() {return pilot;}
    public String getAirframe() {return airframe;}

    public Aircraft(Long id, String airframe, Pilot pilot) {
        this.id = id;
        this.airframe = airframe;
        this.pilot = pilot;
    }

    public Aircraft() {
    }
}
