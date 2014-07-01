package be.vub.smappeerules.core.device;

import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.core.rule.Rule;
import be.vub.smappeerules.core.rule.RuleInterpreter;

/**
 * Created by Jonas on 30/06/2014.
 */
/**public class DeviceManager {
    // All devices and device groups in the app
    List<IDeviceComponent> allComponents = new ArrayList<IDeviceComponent>();

    public IDeviceComponent searchComponent(String name){
        for (int i = 0; i < allComponents.size(); i++){
            if(allComponents.get(i).getName().equals(name))
                return allComponents.get(i);
        }
        return null;
    }


    //TODO PERSISTENT DEVICES

    // All rules in the app
    List<Rule> allRules = new ArrayList<Rule>();

    private void initAllComponents() {
        //TODO API calls to get all present devices
        //TODO add all these devices to the allComponents list
    }

    // Returns list of all devices and device groups
    public List<IDeviceComponent> getAllComponents() {
        return allComponents;
    }

    // Creates a new group
    public void addGroup(DeviceGroup g) {
        allComponents.add(g);
    }

    // Removes a group
    public void removeGroup(DeviceGroup g) {
        allComponents.remove(g);
    }
}
**/