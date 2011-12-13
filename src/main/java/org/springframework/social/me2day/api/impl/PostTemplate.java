package org.springframework.social.me2day.api.impl;

import org.springframework.social.me2day.api.Post;
import org.springframework.social.me2day.api.PostOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class PostTemplate extends AbstractMe2DayOperations implements PostOperations {

    private static final String GET_POSTS = "get_posts/";
    private static final String CREATE_POSTS = "create_posts/";
    
    public PostTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public List<Post> getPosts(String userId) {
        return restTemplate.getForObject(buildUri(GET_POSTS + userId + JSON), PostList.class);
    }

    @Override
    public Post createPost(Post post) {
        requireAuthorization();
        MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
        request.add("post[body]", post.getBody());
        return restTemplate.postForObject(buildUri(CREATE_POSTS + post.getAuthor().getId() + JSON), request, Post.class);
    }

    private static class PostList extends ArrayList<Post> {}
}
