package be.thomasmore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    private Integer id;
    private Double height;
    private String name;
    private String image;
    private String type1;
    private String type2;
    private Double weight;

}
