package be.vub.smappeerules.core.rule;

import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.device.IDeviceComponent;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Rule {
    ITerm term1;
    String op;
    ITerm term2;
    String alert;

    DeviceManager dm;

    public Rule() {}; //TODO delete, was just for testing

    public Rule(DeviceManager dm, ITerm term1, String op, ITerm term2, String alert) {
        this.dm = dm;
        this.term1 = term1;
        this.op = op;
        this.term2 = term2;
        this.alert = alert;
    }

    public String toRuleString() {
        return term1.toRuleString() + "_" + op + "_" + term2.toRuleString() + " -> " + alert;
    }

    public String getAlert() {
        return alert;
    }

    public boolean isTrue() {
        float left = term1.evaluate();
        float right = term2.evaluate();

        if (op.equals("<"))
            return left < right;
        else if (op.equals("<="))
            return left <= right;
        else if (op.equals(">"))
            return left > right;
        else if (op.equals(">="))
            return left >= right;
        else // (op.equals("="))
            return left == right;
    }
}
