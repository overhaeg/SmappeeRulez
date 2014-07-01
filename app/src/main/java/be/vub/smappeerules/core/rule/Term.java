package be.vub.smappeerules.core.rule;

import java.util.Date;

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
            return c.getConsumption(new Date(), new Date());
        } else {    // (this.method.equals("production"))
            return c.getProduction(new Date(), new Date());
        }
    }

    @Override
    public String toRuleString() {
        return c.getName() + ":" + method;
    }
}
