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
        return true;
    }

    @Override
    public void setConnectionValues(Me2Day api, ConnectionValues values) {
        Person codian = api.userOperations().getPerson("codian");
        values.setDisplayName(codian.getNickname());
        values.setImageUrl(codian.getFace());
        values.setProfileUrl(codian.getMe2dayHome());
        values.setProviderUserId(codian.getId());
    }

    @Override
    public UserProfile fetchUserProfile(Me2Day api) {
        return null;
    }

    @Override
    public void updateStatus(Me2Day api, String message) {
    }
}
