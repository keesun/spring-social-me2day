package org.springframework.social.me2day.connect;

import org.springframework.social.ServiceProvider;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.me2day.api.Me2Day;
import org.springframework.social.me2day.auth.Me2DayCridential;

/**
 * @author: Keesun Baik
 */
public class Me2DayConntectionFactory extends ConnectionFactory<Me2Day> {

    public Me2DayConntectionFactory(String akey) {
        super("me2day", new Me2DayServiceProvider(akey), new Me2DayAdapter());
    }

    @Override
    public Connection<Me2Day> createConnection(ConnectionData data) {
        return new Me2DayConnection(data, (Me2DayAdapter)getApiAdapter(), (Me2DayServiceProvider)getServiceProvider());
    }
    
    public Connection<Me2Day> createConnection(Me2DayCridential me2DayCridential) {
        return new Me2DayConnection((Me2DayAdapter)getApiAdapter(), (Me2DayServiceProvider)getServiceProvider(), me2DayCridential);
    }
}
