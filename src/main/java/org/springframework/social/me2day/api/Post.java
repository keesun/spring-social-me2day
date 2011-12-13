package org.springframework.social.me2day.api;

import java.util.Date;
import java.util.List;

/**
 * @author: Keesun Baik
 */
public class Post {

    private String post_id;
    private String identifier;
    private String metoo_at;
    private String domain;
    private String pingback_to;
    private String fromapp;
    private String media;
    private Location location;
    private Author author;
    private String callbackUrl;
    private String iconUrl;
    private String contextType;
    private boolean commentClosed;
    private int metooCount;
    private int commentsCount;
    private Date pubDate;
    private String me2dayPage;
    private List<String> tags;
    private String tagText;
    private String origin_post;
    private String icon;
    private String kind;
    private String textBody;
    private String body;
    private String permalink;
    private String scope;

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMetoo_at() {
        return metoo_at;
    }

    public void setMetoo_at(String metoo_at) {
        this.metoo_at = metoo_at;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPingback_to() {
        return pingback_to;
    }

    public void setPingback_to(String pingback_to) {
        this.pingback_to = pingback_to;
    }

    public String getFromapp() {
        return fromapp;
    }

    public void setFromapp(String fromapp) {
        this.fromapp = fromapp;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public boolean isCommentClosed() {
        return commentClosed;
    }

    public void setCommentClosed(boolean commentClosed) {
        this.commentClosed = commentClosed;
    }

    public int getMetooCount() {
        return metooCount;
    }

    public void setMetooCount(int metooCount) {
        this.metooCount = metooCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getMe2dayPage() {
        return me2dayPage;
    }

    public void setMe2dayPage(String me2dayPage) {
        this.me2dayPage = me2dayPage;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    public String getOrigin_post() {
        return origin_post;
    }

    public void setOrigin_post(String origin_post) {
        this.origin_post = origin_post;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
