package org.springframework.social.me2day.api.impl;

import org.springframework.social.me2day.api.Person;
import org.springframework.social.me2day.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Keesun Baik
 */
public class UserTemplate extends AbstractMe2DayOperations implements UserOperations {

    private static final String GET_PERSON = "get_person/";

    protected UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public Person getPerson(String uid) {
        return restTemplate.getForObject(buildUri(GET_PERSON + uid + JSON), Person.class);
    }
}
