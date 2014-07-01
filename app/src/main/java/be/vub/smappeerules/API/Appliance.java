package be.vub.smappeerules.API;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by overhaeg on 01-07-14.

public class Appliance {

    String id;
    String name;
    String locId;
    SmappeeAPI api;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List<String> getEvent() throws IOException {
        String from = api.getLastUpdate();
        String to =  Long.toString(new Date().getTime());
        return api.getEvents(locId, id, from, to, "1");

    }

    public Appliance(String id, String name, SmappeeAPI api, String locId) {

        this.id = id;
        this.name = name;
        this.api = api;
        this.locId = locId;
    }
}
*/