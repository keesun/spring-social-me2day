package org.springframework.social.me2day.auth;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class Me2DayAuthApiBinding implements ApiBinding {

    private final Me2DayCridential me2DayCridential;

    private final RestTemplate restTemplate;

    /**
     * Constructs the API template without user authorization. This is useful for accessing operations on a provider's API that do not require user authorization.
     */
    protected Me2DayAuthApiBinding() {
        me2DayCridential = null;
        restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
        restTemplate.setMessageConverters(getMessageConverters());
        configureRestTemplate(restTemplate);
    }

    /**
     * Constructs the API template with Me2Day's Auth credential necessary to perform operations on behalf of a user.
     */
    protected Me2DayAuthApiBinding(Me2DayCridential me2DayCridential) {
        this.me2DayCridential = me2DayCridential;
        restTemplate = ProtectedResourceClientFactory.create(me2DayCridential);
        restTemplate.setMessageConverters(getMessageConverters());
        configureRestTemplate(restTemplate);
    }

    /**
     * Set the ClientHttpRequestFactory. This is useful when custom configuration of the request factory is required, such as configuring custom SSL details.
     * @param requestFactory the request factory
     */
    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        if (isAuthorized()) {
            restTemplate.setRequestFactory(ProtectedResourceClientFactory.addMe2DayAuthParam(requestFactory, me2DayCridential));
        } else {
            restTemplate.setRequestFactory(requestFactory);
        }
    }

    // public implementation operations

    /**
     * Obtains a reference to the REST client backing this API binding and used to perform API calls.
     * Callers may use the RestTemplate to invoke other API operations not yet modeled by the binding interface.
     * Callers may also modify the configuration of the RestTemplate to support unit testing the API binding with a mock server in a test environment.
     * During construction, subclasses may apply customizations to the RestTemplate needed to invoke a specific API.
     * @see RestTemplate#setMessageConverters(java.util.List)
     * @see RestTemplate#setErrorHandler(org.springframework.web.client.ResponseErrorHandler)
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public Me2DayCridential getMe2DayCridential() {
        return me2DayCridential;
    }

    // subclassing hooks

    /**
     * Subclassing hook to enable customization of the RestTemplate used to consume provider API resources.
     * An example use case might be to configure a custom error handler.
     * Note that this method is called after the RestTemplate has been configured with the message converters returned from getMessageConverters().
     * @param restTemplate the RestTemplate to configure.
     */
    protected void configureRestTemplate(RestTemplate restTemplate) {
    }

    /**
     * Returns a list of {@link org.springframework.http.converter.HttpMessageConverter}s to be used by the internal {@link RestTemplate}.
     * By default, this includes a {@link org.springframework.http.converter.StringHttpMessageConverter}, a {@link org.springframework.http.converter.json.MappingJacksonHttpMessageConverter}, a {@link org.springframework.http.converter.ByteArrayHttpMessageConverter}, and a {@link org.springframework.http.converter.FormHttpMessageConverter}.
     * The {@link org.springframework.http.converter.FormHttpMessageConverter} is set to use "UTF-8" character encoding.
     * Override this method to add additional message converters or to replace the default list of message converters.
     */
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(getJsonMessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    /**
     * Returns an {@link org.springframework.http.converter.FormHttpMessageConverter} to be used by the internal {@link RestTemplate}.
     * By default, the message converter is set to use "UTF-8" character encoding.
     * Override to customize the message converter (for example, to set supported media types or message converters for the parts of a multipart message).
     * To remove/replace this or any of the other message converters that are registered by default, override the getMessageConverters() method instead.
     */
    protected FormHttpMessageConverter getFormMessageConverter() {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        converter.setCharset(Charset.forName("UTF-8"));
        return converter;
    }

    /**
     * Returns a {@link org.springframework.http.converter.json.MappingJacksonHttpMessageConverter} to be used by the internal {@link RestTemplate}.
     * Override to customize the message converter (for example, to set a custom object mapper or supported media types).
     * To remove/replace this or any of the other message converters that are registered by default, override the getMessageConverters() method instead.
     */
    protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
        return new MappingJacksonHttpMessageConverter();
    }

    /**
     * Returns a {@link org.springframework.http.converter.ByteArrayHttpMessageConverter} to be used by the internal {@link RestTemplate} when consuming image or other binary resources.
     * By default, the message converter supports "image/jpeg", "image/gif", and "image/png" media types.
     * Override to customize the message converter (for example, to set supported media types).
     * To remove/replace this or any of the other message converters that are registered by default, override the getMessageConverters() method instead.
     */
    protected ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
        ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
        return converter;
    }

    
    @Override
    public boolean isAuthorized() {
        return me2DayCridential != null;
    }

}
