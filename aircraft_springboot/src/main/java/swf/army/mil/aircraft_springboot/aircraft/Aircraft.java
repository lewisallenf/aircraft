package swf.army.mil.aircraft_springboot.aircraft;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aircraft{
    @Id
    private Long id;
    String airframe;
    String pilot;

    public void setId(Long id) {this.id = id;}
    public void setPilot(String pilot) {this.pilot = pilot;}
    public void setAirframe(String airframe) {this.airframe = airframe;}

    public Long getId() {return id;}
    public String getPilot() {return pilot;}
    public String getAirframe() {return airframe;}

    public Aircraft(Long id, String airframe, String pilot) {
        this.id = id;
        this.airframe = airframe;
        this.pilot = pilot;
    }

    public Aircraft() {
    }
}
