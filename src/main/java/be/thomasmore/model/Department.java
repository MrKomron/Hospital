package be.thomasmore.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "department_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Column(length = 10000)
    private String depInformation;
    private String city;




    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepInformation() {
        return depInformation;
    }

    public void setDepInformation(String depInformation) {
        this.depInformation = depInformation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
