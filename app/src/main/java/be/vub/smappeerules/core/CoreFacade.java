package be.vub.smappeerules.core;

import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.core.device.IDeviceComponent;

/**
 * Created by Jonas on 30/06/2014.
 */
public class CoreFacade {
    // All devices and device groups in the app
    List<IDeviceComponent> allComponents = new ArrayList<IDeviceComponent>();

    private void initAllComponents() {
        //TODO API calls to get all present devices
        //TODO add all these devices to the allComponents list
    }

    // Returns list of all devices and device groups
    public List<IDeviceComponent> getAllComponents() {
        return allComponents;
    }

    // Adds a new rule
    public void addRule(String rule) {

    }
}
