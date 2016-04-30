package com.yaroslavtir;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {

    /**
     * Serial version uid
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private String id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<ContactPerson> contactPersons = new HashSet<>();

    public Person() {
    }
}
