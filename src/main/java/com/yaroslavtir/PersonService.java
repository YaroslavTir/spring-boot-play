package com.yaroslavtir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YMolodkov on 29.04.2016.
 */
@Service
@Transactional(readOnly = true)
interface  PersonService extends JpaRepository<Person, String> {
}
