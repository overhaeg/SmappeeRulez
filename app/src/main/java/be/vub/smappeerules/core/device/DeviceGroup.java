package be.vub.smappeerules.core.device;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jonas on 30/06/2014.
 */
public class DeviceGroup implements IDeviceComponent {
    String name;
    List<Device> devices;

    public DeviceGroup(String name) {
        this.name = name;
        this.devices = new ArrayList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getProduction(Date startDur, Date endDur) {
        // sum of all productions of devices
        float sum = 0;
        for(int i = 0; i < devices.size(); i++) {
            sum =+ devices.get(i).getProduction(startDur, endDur);
        }
        return sum;
    }

    @Override
    public float getConsumption(Date startDur, Date endDur) {
        // sum of all consumptions of devices
        float sum = 0;
        for(int i = 0; i < devices.size(); i++) {
            sum =+ devices.get(i).getConsumption(startDur, endDur);
        }
        return sum;
    }

    public void addToGroup(Device d) {
        this.devices.add(d);
    }

    public void removeFromGroup(Device d) {
        this.devices.remove(d);
    }
}
