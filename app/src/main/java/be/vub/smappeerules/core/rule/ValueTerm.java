package be.vub.smappeerules.core.rule;

import be.vub.smappeerules.core.rule.ITerm;

/**
 * Created by Jonas on 30/06/2014.
 */
public class ValueTerm implements ITerm {
    float f;

    public ValueTerm(float f) {
        this.f = f;
    }

    public float getValue() {
        return f;
    }

    public void setValue(float value) {
        this.f = value;
    }

    @Override
    public float evaluate() {
        return f;
    }

    @Override
    public String toRuleString() {
        return Float.toString(f);
    }
}
