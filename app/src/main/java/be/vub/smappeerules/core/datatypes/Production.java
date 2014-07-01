package be.vub.smappeerules.core.datatypes;

import be.vub.smappeerules.core.rule.ITerm;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Production implements ITerm {
    float p;

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }

    @Override
    public float evaluate() {
        return 0;
    }

    @Override
    public String toRuleString() {
        return Float.toString(p);
    }
}
