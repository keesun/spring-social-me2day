package org.springframework.social.me2day.api;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author: Keesun Baik
 */
public class PostIcon {
    
    int iconIndex;
    int iconType;
    String url;
    String description;
    @JsonProperty("default") boolean _default;

    public int getIconIndex() {
        return iconIndex;
    }

    public void setIconIndex(int iconIndex) {
        this.iconIndex = iconIndex;
    }

    public int getIconType() {
        return iconType;
    }

    public void setIconType(int iconType) {
        this.iconType = iconType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }
}
