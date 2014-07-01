package be.vub.smappeerules.core.device;

import java.io.IOException;
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
     * Returns the energy production for a device/group for a given duration
     * @param startDur      start time of duration
     * @param endDur        end time of duration
     * @return  production value
     */
    public float getProduction(Date startDur, Date endDur) throws IOException;

    /**
     * Returns the energy consumption for a device/group for a given duration
     * @param startDur      start time of duration
     * @param endDur        end time of duration
     * @return
     */
    public float getConsumption(Date startDur, Date endDur) throws IOException;
}
