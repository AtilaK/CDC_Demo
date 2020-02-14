package com.msg.group;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
class PersonService {

    private final Map<Long, Person> personMap;

    public PersonService() {
        personMap = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            File file = new File(getClass().getClassLoader().getResource("persons.json").getFile());
            Person[] personArray = objectMapper.readValue(file, Person[].class);

            for (Person person: personArray) {
                personMap.put(person.getId(), person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Person findPersonById(Long id) throws PersonNotFoundException{

        Person person = personMap.get(id);
        if ( person == null) {
            throw new PersonNotFoundException();
        }
        return person;
    }
}