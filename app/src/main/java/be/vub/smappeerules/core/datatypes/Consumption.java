package be.vub.smappeerules.core.datatypes;

import be.vub.smappeerules.core.rule.ITerm;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Consumption implements Evaluated, ITerm {
    float c;

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    @Override
    public String toRuleString() {
        return Float.toString(c);
    }
}
