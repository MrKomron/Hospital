package be.thomasmore.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SERVICES")
public class Services {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "services_generator")
    @SequenceGenerator(name = "services_generator", sequenceName = "services_seq",  initialValue=1 , allocationSize = 1)
    @Id
    private Integer id;
    @NotBlank
    private String name;
    @Column(length = 10000)
    @NotBlank
    private String procInformation;
    @Column(length = 10000)
    @NotBlank
    private String canInformation;


    public Services() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcInformation() {
        return procInformation;
    }

    public void setProcInformation(String procInformation) {
        this.procInformation = procInformation;
    }


    public String getCanInformation() {
        return canInformation;
    }

    public void setCanInformation(String canInformation) {
        this.canInformation = canInformation;
    }
}
