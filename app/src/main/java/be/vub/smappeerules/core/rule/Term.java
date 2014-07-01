package be.vub.smappeerules.core.rule;

import java.io.IOException;
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
            try {
                return c.getConsumption(new Date(), new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {    // (this.method.equals("production"))
            try {
                return c.getProduction(new Date(), new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Float.parseFloat(null);
    }

    @Override
    public String toRuleString() {
        return c.getName() + ":" + method;
    }
}
