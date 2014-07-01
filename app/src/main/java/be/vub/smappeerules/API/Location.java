package be.vub.smappeerules.API;

import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * Created by overhaeg on 01-07-14.
 */
public class Location {

    String id;
    String name;
    String timezone;
    String lon;
    String lat;
    String electricityCost;
    String electricityCurr;
    List<Appliance> appliances;

    public Location(String id, String name) {
        this.id = id;
        this.name = name;
    }



    public void updateLocation(String timezone, String lon, String lat, String electricityCost, String electricityCurr, List<Appliance> appliances)
    {
        this.timezone = timezone;
        this.lon = lon;
        this.lat = lat;
        this.electricityCost = electricityCost;
        this.electricityCurr = electricityCurr;
        this.appliances = appliances;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getElectricityCost() {
        return electricityCost;
    }

    public String getElectricityCurr() {
        return electricityCurr;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", timezone='" + timezone + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", electricityCost='" + electricityCost + '\'' +
                ", electricityCurr='" + electricityCurr + '\'' +
                ", appliances=" + appliances.size() +
                '}';
    }
}

