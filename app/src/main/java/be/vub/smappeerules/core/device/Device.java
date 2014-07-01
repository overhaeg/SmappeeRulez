package be.vub.smappeerules.core.device;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import be.vub.smappeerules.API.SmappeeAPI;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Device implements IDeviceComponent {
    String name;
    SmappeeAPI api;

    public Device(String name, SmappeeAPI api) {
        this.name = name;
        this.api = api;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getProduction(Date startDur, Date endDur) throws IOException {
        List<String> p = api.getEvents(name);
        return Float.parseFloat(p.get(0));
    }

    @Override
    public float getConsumption(Date startDur, Date endDur) throws IOException {
        List<String> c = api.getEvents(name);
        return Float.parseFloat(c.get(0));
    }
}
