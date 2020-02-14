package com.msg.group;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BPIRestController {

    private final RestTemplate restTemplate;

    public BPIRestController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        }

        @RequestMapping(value="/basic-person-information/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        BasicPersonInformation getMessage(@PathVariable("personId") Long personId) {

            Person person = null;

            try {
                person = this.restTemplate.getForObject("http://localhost:8000/persons/{personId}", Person.class, personId);
            } catch (HttpClientErrorException.NotFound ex) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No person with the given id "+personId+" found!", ex);
            }

            BasicPersonInformation bpi = new BasicPersonInformation();
            bpi.setSearchString(""+personId);

            bpi.setMessage("Providing basic information about the person");
            bpi.setId(person.getId());
            bpi.setName(person.getName());
            bpi.setSurname(person.getSurname());
            bpi.setSpecies(person.getSpecies());

            return bpi;
        }

}
