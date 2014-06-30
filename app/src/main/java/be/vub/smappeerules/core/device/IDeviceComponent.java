package be.vub.smappeerules.core.device;

import java.util.Date;

/**
 * Created by Jonas on 30/06/2014.
 */
public interface IDeviceComponent {
    /**
     * Returns name of device/group
     */
    public String getName();

    /**
     * Sets name of device/group
     */
    public void setName(String name);

    /**
     * Returns the energy production for a device/group for a given duration
     * @param startDur      start time of duration
     * @param endDur        end time of duration
     * @return  production value
     */
    public float getProduction(Date startDur, Date endDur);

    /**
     * Returns the energy consumption for a device/group for a given duration
     * @param startDur      start time of duration
     * @param endDur        end time of duration
     * @return
     */
    public float getConsumption(Date startDur, Date endDur);

    /**
     * Returns whether the device is currently on
     */
    public boolean isOn();

    /**
     * Returns whether the device is currently off
     */
    public boolean isOff();

    /**
     * Returns how long the device is currently on or off
     */
    public float getStatusDuration();

}
