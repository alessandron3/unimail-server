package br.com.unicarioca.unimail.rmi;

import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */
public class MessageDTO implements Serializable {

    private String from;

    private String to;

    private String title;

    public MessageDTO(String from, String to, String title) {
        this.from = from;
        this.to = to;
        this.title = title;
    }

    public MessageDTO() {}

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
}

