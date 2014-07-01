package be.vub.smappeerules.core.device;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.API.SmappeeAPI;

/**
 * Created by Jonas on 30/06/2014.
 */
public class DeviceManager {
    // All devices and device groups in the app
    List<IDeviceComponent> allComponents = new ArrayList<IDeviceComponent>();

    SmappeeAPI api;

    Context ctx;

    public DeviceManager(SmappeeAPI api, Context ctx) throws IOException {
        this.api = api;
        //api.getServiceLocations();
        //api.getServiceLocationInfo();TODO
        this.ctx = ctx;
        initAllComponents();
    }

    public IDeviceComponent searchComponent(String name){
        for (int i = 0; i < allComponents.size(); i++){
            if(allComponents.get(i).getName().equals(name))
                return allComponents.get(i);
        }
        return null;
    }

    private DeviceGroup StringToDeviceGroup(String s){
        String[] temp;
        String delimeter = ", ";
        temp = s.split(delimeter);
        DeviceGroup d = new DeviceGroup(temp[0]);
        for(int i = 1; i < temp.length ; i++){
            // API
            d.addToGroup(new Device(temp[i], api));
        }
        return d;
    }

    public void readFromFile(Context ctx) {
        try {
            String fileName = "devicesgroup.txt";
            File devicesFile = new File(ctx.getFilesDir(), fileName);
            BufferedReader br = new BufferedReader(new FileReader(devicesFile));
            String line = br.readLine();

            while (line != null) {
                allComponents.add(StringToDeviceGroup(line));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initAllComponents() {
        //List<String> names = api.getApplianceNames();
        List<String> names = new ArrayList<String>();
        names.add("Solar Panel");
        names.add("TV");
        names.add("refrigirator");
        names.add("oven");
        names.add("iron");
        names.add("radio");
        names.add("kitchen light");
        names.add("bedroom light");
        for(int i = 0; i < names.size(); i++) {
            allComponents.add(new Device(names.get(i), api));
        }
        readFromFile(ctx);
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
