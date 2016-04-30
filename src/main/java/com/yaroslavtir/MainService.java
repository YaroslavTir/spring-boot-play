package com.yaroslavtir;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class MainService {
    public static final String PERSON_ID = "test";
    private final AtomicInteger idGeneration = new AtomicInteger(1000);

    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private PersonService personService;

    @Transactional
    public String  savePerson(){
        Person person = new Person();
//        person.setId(PERSON_ID);
        Person newPerson = personService.save(person);
        return newPerson.getId();
    }

    @Transactional
    public void test1(String id){
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId("contactPerson");
        contactPerson.setPerson(personService.getOne(id));
        contactPersonService.save(contactPerson);
    }



    @Transactional
    public void test2(){

        Person person = new Person();
        person.setId("test2");
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId("contactPerson2");
        contactPerson.setPerson(person);
        contactPersonService.save(contactPerson);
    }


    @Transactional
    public void test3(){

        Person person = new Person();
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId("contactPerson2");
        contactPerson.setPerson(person);
        contactPersonService.save(contactPerson);
    }
}