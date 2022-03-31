package be.thomasmore.model;

import javax.persistence.*;

@Entity
public class Services {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "services_generator")
    @SequenceGenerator(name = "services_generator", sequenceName = "services_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    private String Information;


    public Services(Integer id, String name, String moreInformation) {
        this.id = id;
        this.name = name;
        this.Information = moreInformation;

    }

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

    public String getMoreInformation() {
        return Information;
    }

    public void setMoreInformation(String moreInformation) {
        this.Information = moreInformation;
    }

}
