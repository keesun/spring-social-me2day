package org.springframework.social.me2day.api;

/**
 * @author: Keesun Baik
 */
public class Celebrity {
    
    private String name;
    private String profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
