package org.springframework.social.me2day.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.me2day.api.Me2Day;
import org.springframework.social.me2day.api.Person;

/**
 * @author: Keesun Baik
 */
public class Me2DayAdapter implements ApiAdapter<Me2Day> {

    //TODO

    @Override
    public boolean test(Me2Day api) {
        //TODO use nope
        return false;
    }

    @Override
    public void setConnectionValues(Me2Day api, ConnectionValues values) {
//        Person person = api.userOperations().getPerson();
    }

    @Override
    public UserProfile fetchUserProfile(Me2Day api) {
        return null;
    }

    @Override
    public void updateStatus(Me2Day api, String message) {
    }
}
