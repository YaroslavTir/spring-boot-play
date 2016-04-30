package com.yaroslavtir;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contact_persons")
@Getter
@Setter
public class ContactPerson {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;


    public ContactPerson() {
    }
}
