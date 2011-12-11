package org.springframework.social.me2day.api;

import org.springframework.social.ApiBinding;

/**
 * @author: Keesun Baik
 */
public interface Me2Day extends ApiBinding {

    /**
     * 글 관련 기능
     * @return
     */
    ArticleOperations articleOperations();

    /**
     * 댓글 관련 기능
     * @return
     */
    ReplyOperations replyOperations();

    /**
     * 미투 관련 기능
     * @return
     */
    MeTooOperations meTooOperations();

    /**
     * 친구 관련 기능
     * @return
     */
    FriendsOperations friendsOperations();

    /**
     * 사용자 관련 기능
     * @return
     */
    UserOperations userOperations();

    /**
     * 글쓰지 링크 관련 기능
     * @return
     */
    ArticleLinkOperations articleLinkOperations();

    /**
     * 기타 기능
     * @return
     */
    EtcOperations etcOperations();


}
