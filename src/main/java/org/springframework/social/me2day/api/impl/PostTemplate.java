package org.springframework.social.me2day.api.impl;

import org.springframework.social.me2day.api.Post;
import org.springframework.social.me2day.api.PostOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class PostTemplate extends AbstractMe2DayOperations implements PostOperations {

    private static final String GET_POSTS = "get_posts/";
    
    public PostTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public List<Post> getPosts(String userId) {
        return restTemplate.getForObject(GET_POSTS + userId + JSON, PostList.class);
    }

    private static class PostList extends ArrayList<Post> {}
}
