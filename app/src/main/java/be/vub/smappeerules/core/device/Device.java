package be.vub.smappeerules.core.device;

import java.util.Date;

import be.vub.smappeerules.API.Appliance;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Device implements IDeviceComponent {
    String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getProduction(Date startDur, Date endDur) {
        //TODO vraag appliance met naam aan API
        return 0;
    }

    @Override
    public float getConsumption(Date startDur, Date endDur) {
        //TODO vraag appliance met naam aan API
        return 0;
    }
}
