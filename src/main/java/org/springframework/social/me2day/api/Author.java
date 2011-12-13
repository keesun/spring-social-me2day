package org.springframework.social.me2day.api;

/**
 * @author: Keesun Baik
 */
public class Author {

    String id;
    String nickname;
    String face;
    String me2dayHome;
    String relationship;
    String homePage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMe2dayHome() {
        return me2dayHome;
    }

    public void setMe2dayHome(String me2dayHome) {
        this.me2dayHome = me2dayHome;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
