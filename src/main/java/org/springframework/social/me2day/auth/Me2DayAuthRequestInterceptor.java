package org.springframework.social.me2day.auth;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.social.support.URIBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author: Keesun Baik
 */
public class Me2DayAuthRequestInterceptor implements ClientHttpRequestInterceptor {

    private final Me2DayCridential me2DayCridential;
    private final ClientHttpRequestFactory requestFactory;

    public Me2DayAuthRequestInterceptor(Me2DayCridential me2DayCridential1, ClientHttpRequestFactory requestFactory) {
        this.me2DayCridential = me2DayCridential1;
        this.requestFactory = requestFactory;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        URI me2dayAuthUri = URIBuilder.fromUri(request.getURI().toString()).queryParam("uid", me2DayCridential.getUid()).queryParam("ukey", me2DayCridential.getUkey()).build();
        HttpRequest httpRequest = requestFactory.createRequest(me2dayAuthUri, HttpMethod.GET);
        return execution.execute(httpRequest, body);
    }

}
