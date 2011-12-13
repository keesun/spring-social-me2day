package org.springframework.social.me2day.connect;

import org.springframework.social.ServiceProvider;
import org.springframework.social.me2day.api.Me2Day;
import org.springframework.social.me2day.api.impl.Me2DayTemplate;
import org.springframework.social.me2day.auth.Me2DayAuthOperations;import org.springframework.social.me2day.auth.Me2DayAuthTemplate;
import org.springframework.social.me2day.auth.Me2DayCridential;

import javax.swing.*;

/**
 * @author: Keesun Baik
 */
public class Me2DayServiceProvider implements ServiceProvider<Me2Day> {
    
    private final Me2DayAuthOperations me2DayAuthOperations;

    public Me2DayServiceProvider(String akey) {
        me2DayAuthOperations = new Me2DayAuthTemplate(akey);
    }

    public Me2DayAuthOperations getMe2DayAuthOperations(){
        return this.me2DayAuthOperations;
    }

    public Me2Day getApi(Me2DayCridential me2DayCridential){
        return new Me2DayTemplate(me2DayCridential);
    }
    
}
