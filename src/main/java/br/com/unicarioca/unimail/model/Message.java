package br.com.unicarioca.unimail.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "[from]")
    private String from;

    @Column(name = "[to]")
    private String to;

    @Column(length = 100)
    private String title;
    @Column(length = 1000)
    private String message;


    public Message(String from, String to, String title, String message) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.message = message;
    }

    public Message() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Message{");
        sb.append("id=").append(id);
        sb.append(", from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
