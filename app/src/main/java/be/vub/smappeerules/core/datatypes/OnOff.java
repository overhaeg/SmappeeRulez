package be.vub.smappeerules.core.datatypes;

import be.vub.smappeerules.core.rule.ITerm;

/**
 * Created by Jonas on 30/06/2014.
 */
public class OnOff implements Evaluated, ITerm {
    boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toRuleString() {
        if(status)
            return "TRUE";
        else
            return "FALSE";
    }
}
