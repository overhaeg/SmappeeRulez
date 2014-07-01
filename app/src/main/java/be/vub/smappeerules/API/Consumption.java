package be.vub.smappeerules.API;

/**
 * Created by overhaeg  on 01-07-14.
 */
public class Consumption {

    String timestamp;
    String consumption;
    String solar;
    String alwaysOn;

    public Consumption(String timestamp, String consumption, String solar, String alwaysOn) {
        this.timestamp = timestamp;
        this.consumption = consumption;
        this.solar = solar;
        this.alwaysOn = alwaysOn;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "timestamp='" + timestamp + '\'' +
                ", consumption='" + consumption + '\'' +
                ", solar='" + solar + '\'' +
                ", alwaysOn='" + alwaysOn + '\'' +
                '}';
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAlwaysOn() {
        return alwaysOn;
    }

    public String getSolar() {
        return solar;
    }

    public String getConsumption() {
        return consumption;
    }
}
