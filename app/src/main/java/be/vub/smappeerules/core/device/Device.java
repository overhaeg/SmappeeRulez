package be.vub.smappeerules.core.device;

import java.util.Date;

import be.vub.smappeerules.API.Appliance;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Device implements IDeviceComponent {
    Appliance appl;

    public Device(Appliance appl) {
        this.appl = appl;
    }

    @Override
    public String getName() {
        return appl.getName();
    }

    /*@Override
    public void setName(String name) {
        this.name = name;
    }*/

    @Override
    public float getProduction(Date startDur, Date endDur) {
        //TODO appl.getProduction();
        return 0;
    }

    @Override
    public float getConsumption(Date startDur, Date endDur) {
        //TODO appl.getConsumption();
        return 0;
    }
}
