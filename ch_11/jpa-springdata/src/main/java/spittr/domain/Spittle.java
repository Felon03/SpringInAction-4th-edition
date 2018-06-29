package spittr.domain;

import sun.java2d.pipe.SpanIterator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 9:19
 * Description: Message of Spittr
 */

@Entity
public class Spittle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spitter")
    private Spitter spitter;

    @Column
    private String message;

    @Column
    private Date postedTime;

    private Spittle() {

    }

    public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return id;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public String getMessage() {
        return message;
    }

    public Date getPostedTime() {
        return postedTime;
    }
}
