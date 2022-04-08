package be.thomasmore.model;

import javax.persistence.*;

@Entity
public class Faq {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faq_generator")
    @SequenceGenerator(name = "faq_generator", sequenceName = "faq_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Column(length = 1000)
    private String question;
    @Column(length = 1000)
    private String answer;

    public Faq() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
