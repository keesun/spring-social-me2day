package org.springframework.social.me2day.connect;

import org.springframework.social.ServiceProvider;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.AbstractConnection;
import org.springframework.social.me2day.api.Me2Day;
import org.springframework.social.me2day.auth.Me2DayCridential;

/**
 * @author: Keesun Baik
 */
public class Me2DayConnection extends AbstractConnection<Me2Day> {

    private Me2Day api;
    private Me2DayCridential me2DayCridential;
    private Me2DayServiceProvider serviceProvider;
            

    public Me2DayConnection(Me2DayAdapter me2DayApiAdapter, Me2DayServiceProvider serviceProvider, Me2DayCridential me2DayCridential) {
        super(me2DayApiAdapter);
        this.me2DayCridential = me2DayCridential;
        this.api = serviceProvider.getApi(me2DayCridential);
    }

    public Me2DayConnection(ConnectionData data, Me2DayAdapter me2DayApiAdapter, Me2DayServiceProvider serviceProvider) {
        super(data, me2DayApiAdapter);
        this.me2DayCridential = new Me2DayCridential(data.getProviderUserId(), data.getSecret());
        this.api = serviceProvider.getApi(this.me2DayCridential);
    }

    @Override
    public Me2Day getApi() {
        synchronized (getMonitor()) {
            return api;
        }
    }

    @Override
    public ConnectionData createData() {
        synchronized (getMonitor()) {
            return new ConnectionData(getKey().getProviderId(), getKey().getProviderUserId(), getDisplayName(), getProfileUrl(), getImageUrl(), null, me2DayCridential.getUkey(), null, null);
        }
    }
}
