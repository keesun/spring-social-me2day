package org.springframework.social.me2day.auth;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.support.URIBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author: Keesun Baik
 */
public class Spring30OAuth2RequestFactory implements ClientHttpRequestFactory {
    
    private final ClientHttpRequestFactory delegate;
    private final Me2DayCridential me2DayCridential;
    
    public Spring30OAuth2RequestFactory(ClientHttpRequestFactory delegate, Me2DayCridential me2DayCridential) {
        this.delegate = delegate;
        this.me2DayCridential = me2DayCridential;
    }

    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        URI me2dayAuthUri = URIBuilder.fromUri(uri.toString()).queryParam("uid", me2DayCridential.getUid()).queryParam("ukey", me2DayCridential.getUkey()).build();
        return delegate.createRequest(me2dayAuthUri, HttpMethod.GET);
    }
}
