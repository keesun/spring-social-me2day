package org.springframework.social.me2day.api;

import java.util.List;

/**
 * @author: Keesun Baik
 */
public interface PostOperations {

    List<Post> getPosts(String userId);

    Post createPost(Post post);

}
