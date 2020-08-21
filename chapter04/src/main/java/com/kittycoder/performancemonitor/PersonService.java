package com.kittycoder.performancemonitor;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by shucheng on 2020/8/5 22:22
 */
public class PersonService {

    public String getFullName(Person person) {
        return person.getLastName() + " " + person.getFirstName();
    }

    public int getAge(Person person) {
        Period p = Period.between(person.getDateOfBirth(), LocalDate.now());
        return p.getYears();
    }
}
