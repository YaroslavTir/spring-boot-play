package com.yaroslavtir;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application {
    public static void main(String... args) throws IOException {
        ApplicationContext appContext = SpringApplication.run(Application.class, args);
        ContactService contactService = appContext.getBean(ContactService.class);
        contactService.loadContacts(Application.class.getResource("contacts.txt").getPath());
    }
}