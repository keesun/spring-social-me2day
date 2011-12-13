package org.springframework.social.me2day.api.impl;

import org.springframework.social.me2day.api.*;
import org.springframework.social.me2day.auth.Me2DayAuthApiBinding;
import org.springframework.social.me2day.auth.Me2DayCridential;

/**
 * @author: Keesun Baik
 */
public class Me2DayTemplate extends Me2DayAuthApiBinding implements Me2Day {

    PostOperations postOperations;
    ReplyOperations replyOperations;
    MeTooOperations meTooOperations;
    FriendsOperations friendsOperations;
    UserOperations userOperations;
    ArticleLinkOperations articleLinkOperations;
    EtcOperations etcOperations;

    public Me2DayTemplate() {
        super();
        initSubApis();
    }

    public Me2DayTemplate(Me2DayCridential me2DayCridential) {
        super(me2DayCridential);
        initSubApis();
    }

    private void initSubApis() {
        this.postOperations = new PostTemplate(getRestTemplate(), isAuthorized());
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
        //TODO


    }


    @Override
    public PostOperations articleOperations() {
        return null;
    }

    @Override
    public ReplyOperations replyOperations() {
        return null;
    }

    @Override
    public MeTooOperations meTooOperations() {
        return null;
    }

    @Override
    public FriendsOperations friendsOperations() {
        return null;
    }

    @Override
    public UserOperations userOperations() {
        return null;
    }

    @Override
    public ArticleLinkOperations articleLinkOperations() {
        return null;
    }

    @Override
    public EtcOperations etcOperations() {
        return null;
    }
}
