package be.vub.smappeerules.core.rule;

import java.util.Date;

import be.vub.smappeerules.core.datatypes.Consumption;
import be.vub.smappeerules.core.datatypes.Evaluated;
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

    public Evaluated evaluate() {
        if (this.method.equals("consumption")) {
            //TODO parse ...(...-...)
            Date start = new Date();
            Date end = new Date();

            Consumption cons = new Consumption();
            cons.setC(c.getConsumption(start, end));
            return cons;
        } else if (this.method.equals("production")) {

        } else if (this.method.equals("on/off")) {

        } else if (this.method.equals("on/off_duration")) {

        }



    }

    @Override
    public String toRuleString() {
        return "";
    }
}
