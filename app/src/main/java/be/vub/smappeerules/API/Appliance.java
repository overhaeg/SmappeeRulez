package be.vub.smappeerules.API;

/**
 * Created by MacEugene on 01-07-14.
 */
public class Appliance {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Appliance(String id, String name) {

        this.id = id;
        this.name = name;
    }
}
