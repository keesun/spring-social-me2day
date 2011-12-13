package org.springframework.social.me2day.auth;

/**
 * @author: Keesun Baik
 */
public class Me2DayCridential {
    
    private final String ukey;
    private final String uid;

    public Me2DayCridential(String ukey, String uid) {
        this.ukey = ukey;
        this.uid = uid;
    }

    public String getUkey() {
        return ukey;
    }

    public String getUid() {
        return uid;
    }
}
