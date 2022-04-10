package be.thomasmore.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "NEWS")
public class News {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_generator")
    @SequenceGenerator(name = "news_generator", sequenceName = "news_seq",  initialValue=1, allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    @Column(length = 10000)
    private String text;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
