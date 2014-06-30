package be.vub.smappeerules.core.rule;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Rule {
    ITerm term1;
    Operator op;
    ITerm term2;



    public String toRuleString() {
        return ifPart.toRuleString() + thenPart.toRuleString();
    }
}
