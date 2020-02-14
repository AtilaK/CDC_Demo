package com.msg.group;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PRServiceApplication.class)
public class BaseTestClass {

    @Autowired WebApplicationContext webAppContext;
    @Autowired PersonRestController personRestController;
    @MockBean PersonService personService;

    @Before public void setup() throws PersonNotFoundException, ParseException {

        RestAssuredMockMvc.webAppContextSetup(webAppContext);

        Date born = new SimpleDateFormat("yyyy").parse("3551");
        Date died = new SimpleDateFormat("yyyy").parse("3601");

        Mockito.when(personService.findPersonById(1L))
                .thenReturn(new Person(1L, "Anakin", "Skywalker", born, died, "Human", null, null, null));

        Mockito.when(personService.findPersonById(1000L)).thenThrow(new PersonNotFoundException());
    }

}
