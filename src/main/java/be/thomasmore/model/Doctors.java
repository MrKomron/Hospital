package be.thomasmore.model;

import javax.persistence.*;

@Entity
public class Doctors {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_generator")
    @SequenceGenerator(name = "doctors_generator", sequenceName = "doctors_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private int phoneNumber;
    @Column(length = 1000)
    private String bio;
    private String department;
    @Column(nullable = true, length = 64)
    private String photos;

    public Doctors(Integer id, String firstname, String lastname, int age, String email, int phoneNumber, String bio, String department, String photos) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.department = department;
        this.photos = photos;
    }

    public Doctors() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
