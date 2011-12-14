package org.springframework.social.me2day.api;

import java.util.Date;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class Person {
    
    String id;
    String openid;
    String nickname;
    String face;
    String face_auto;
    String descriptions;
    String homepage;
    String email;
    String celphone;
    String messenger;
    String realname;
    Date birthday;
    Location location;
    Celebrity celebrity;
    String me2dayHome;
    String rssDaily;
    String invitedBy;
    int friendsCount;
    int pinMeCount;
    Date updated;
    int totalPosts;
    Date registered;
    boolean autoAccept;
    List<PostIcon> postIcons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public String getFace_auto() {
        return face_auto;
    }

    public void setFace_auto(String face_auto) {
        this.face_auto = face_auto;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public String getMe2dayHome() {
        return me2dayHome;
    }

    public void setMe2dayHome(String me2dayHome) {
        this.me2dayHome = me2dayHome;
    }

    public String getRssDaily() {
        return rssDaily;
    }

    public void setRssDaily(String rssDaily) {
        this.rssDaily = rssDaily;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getPinMeCount() {
        return pinMeCount;
    }

    public void setPinMeCount(int pinMeCount) {
        this.pinMeCount = pinMeCount;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public boolean isAutoAccept() {
        return autoAccept;
    }

    public void setAutoAccept(boolean autoAccept) {
        this.autoAccept = autoAccept;
    }

    public List<PostIcon> getPostIcons() {
        return postIcons;
    }

    public void setPostIcons(List<PostIcon> postIcons) {
        this.postIcons = postIcons;
    }
}
