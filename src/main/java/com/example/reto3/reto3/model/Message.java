package com.example.reto3.reto3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="message")
public class Message {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messagetext;

    @ManyToOne
    @JoinColumn(name="machineId")
    @JsonIgnoreProperties("messages")
    private Machine machine;

    public String getMessageText() {
        return messagetext;
    }

    public void setMessageText(String menssagetext) {
        this.messagetext = menssagetext;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine2) {
        this.machine = machine2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}    
