package swf.army.mil.aircraft_springboot.Pilot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pilot{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private int age;

    public Long getId() {return id;}
    public String getLname() {return lname;}
    public String getFname() {return fname;}
    public int getAge(){return age;}

    public void setId(Long id) {this.id = id;}
    public void setFname(String fname) {this.fname = fname;}
    public void setLname(String lname) {this.lname = lname;}
    public void setAge(int age){this.age = age;}

    public Pilot(Long id, String fname, String lname, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    public Pilot() {
    }
}
