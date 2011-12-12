package org.springframework.social.me2day.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author: Keesun Baik
 */
public class AbstractMe2DayOperations {

    protected final RestTemplate restTemplate;
    protected final boolean isAuthorized;
    protected static final String JSON = ".json";

    protected AbstractMe2DayOperations(RestTemplate restTemplate, boolean isAuthorized) {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException();
        }
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }

    private static final String API_URL_BASE = "https://me2day.net/api/";

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();


}
