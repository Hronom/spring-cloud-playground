package com.github.hronom.shitstorageservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shit {
    @Id
    @GeneratedValue
    private Long id;

    private String source;

    private String text;

    public Shit(String source, String text) {
        this.source = source;
        this.text = text;
    }

    public Shit() {

    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Shit{" + "id=" + id + ", source='" + source + '\'' + ", text='" + text + '\'' + '}';
    }
}
