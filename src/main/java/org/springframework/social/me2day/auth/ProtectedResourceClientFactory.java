package org.springframework.social.me2day.auth;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class ProtectedResourceClientFactory {

    private static boolean interceptorsSupported = ClassUtils.isPresent("org.springframework.http.client.ClientHttpRequestInterceptor", ProtectedResourceClientFactory.class.getClassLoader());

    private static boolean listBasedInterceptors = false;

    private static Method setInterceptorsMethod;

    static {
        if (interceptorsSupported) {
            try {
                setInterceptorsMethod = RestTemplate.class.getMethod("setInterceptors", List.class);
                listBasedInterceptors = true;
            } catch (NoSuchMethodException e) {
                try {
                    setInterceptorsMethod = RestTemplate.class.getMethod("setInterceptors", new ClientHttpRequestInterceptor[0].getClass());
                } catch (NoSuchMethodException shouldntHappen) {}
            }
        }
    }

    public static RestTemplate create(Me2DayCridential me2DayCridential) {
        RestTemplate client = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
        if (interceptorsSupported) {
            // favored
            Me2DayAuthRequestInterceptor interceptor = new Me2DayAuthRequestInterceptor(me2DayCridential, client.getRequestFactory());
            try {
                if (listBasedInterceptors) {
                    List<ClientHttpRequestInterceptor> interceptors = new LinkedList<ClientHttpRequestInterceptor>();
                    interceptors.add(interceptor);
                    setInterceptorsMethod.invoke(client, interceptors);
                } else {
                    setInterceptorsMethod.invoke(client, new Object[] {new ClientHttpRequestInterceptor[] { interceptor }});
                }
            } catch (Exception shouldntHappen) {}
        } else {
            // 3.0.x compatibility
            client.setRequestFactory(new Spring30OAuth2RequestFactory(client.getRequestFactory(), me2DayCridential));
        }
        return client;
    }

    public static ClientHttpRequestFactory addMe2DayAuthParam(ClientHttpRequestFactory requestFactory, Me2DayCridential me2DayCridential) {
        if (interceptorsSupported) {
            return requestFactory;
        }
        return new Spring30OAuth2RequestFactory(requestFactory, me2DayCridential);
    }

}
