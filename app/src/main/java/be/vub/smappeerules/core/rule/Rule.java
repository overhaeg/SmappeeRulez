package be.vub.smappeerules.core.rule;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Rule {


    public String toRuleString() {
        return ifPart.toRuleString() + thenPart.toRuleString();
    }
}
