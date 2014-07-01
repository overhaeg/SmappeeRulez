package be.vub.smappeerules.core.rule;

import java.util.Date;

import be.vub.smappeerules.core.datatypes.Consumption;
import be.vub.smappeerules.core.device.IDeviceComponent;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Term implements ITerm {
    IDeviceComponent c;
    String method;

    public Term(IDeviceComponent c, String method) {
        this.c = c;
        this.method = method;
    }

    @Override
    public float evaluate() {
        if (this.method.equals("consumption")) {
            //TODO parse ...(...-...)
            Date start = new Date();
            Date end = new Date();
            return c.getConsumption(start, end);
        } else {    // (this.method.equals("production"))
            //TODO parse ...(...-...)
            Date start = new Date();
            Date end = new Date();
            return c.getProduction(start, end);
        }
    }

    @Override
    public String toRuleString() {
        return "";
    }
}
