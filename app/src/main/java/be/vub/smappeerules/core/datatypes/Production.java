package be.vub.smappeerules.core.datatypes;

import be.vub.smappeerules.core.rule.ITerm;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Production implements Evaluated, ITerm {
    float p;

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }

    @Override
    public String toRuleString() {
        return Float.toString(p);
    }
}
