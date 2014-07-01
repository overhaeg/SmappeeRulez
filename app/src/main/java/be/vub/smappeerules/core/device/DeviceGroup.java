package be.vub.smappeerules.core.device;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    @Override
    public boolean isOn() {
        // all devices on?
        boolean acc = true;
        for(int i = 0; i < devices.size(); i++) {
            acc = acc && devices.get(i).isOn();
        }
        return acc;
    }

    @Override
    public boolean isOff() {
        // all devices on?
        boolean acc = true;
        for(int i = 0; i < devices.size(); i++) {
            acc = acc && devices.get(i).isOff();
        }
        return acc;
    }

    @Override
    public float getStatusDuration() {
        // sum of all consumptions of devices
        float sum = 0;
        for(int i = 0; i < devices.size(); i++) {
            sum =+ devices.get(i).getStatusDuration();
        }
        return sum;
    }

    public void addToGroup(Device d) {
        this.devices.add(d);
    }

    public void removeFromGroup(Device d) {
        this.devices.remove(d);
    }


    //helpfunction
    public String listToString(List<Device> d){
        String devices = " ";
        for(int i = 0; i < d.size() ; i++)
            devices += d.get(i).getName() + ", ";
        return devices;
    }

    public void writeToFile(Context ctx){
        String fileName = "devicesgroup.txt";

        File devicesFile = new File(ctx.getFilesDir(), fileName);

        // This will reference one line at a time
        String line = null;

        try {
            FileWriter filewriter = new FileWriter(devicesFile, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.write(name + "," + listToString(this.devices)+ System.getProperty("line.separator"));
            out.close();

           /* OutputStreamWriter outputStreamWriter = new OutputStreamWriter()amWriter((fileName, Context.MODE_APPEND));
            outputStreamWriter.write(name + "," + listToString(this.devices)+ "/n");
            outputStreamWriter.close();      */
            BufferedReader br = new BufferedReader(new FileReader(devicesFile));
            Log.i("test", br.readLine());
            Log.i("testy", br.readLine());
            /**
            FileWriter fileWriter = new FileWriter(fileName, true);


            //FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(name + "," + listToString(this.devices) );
            bufferedWriter.close(); **/
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
