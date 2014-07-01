package be.vub.smappeerules.core.rule;

import be.vub.smappeerules.core.device.DeviceManager;

/**
 * Created by Jonas on 30/06/2014.
 */

public class RuleInterpreter {
    public Rule interpretRule(String rule, DeviceManager dm) {
        //Parse ...->...
        //Sub-parse ..._<OP>_... (Term1, Term2)
        String[] ruleParts = rule.split(" -> ");
        String ifPart = ruleParts[0];
        String thenPart = ruleParts[1];

        String[] ifParts = ifPart.split("_");
        String term1 = ifParts[0];
        String op = ifParts[1];
        String term2 = ifParts[2];

        Rule r = new Rule(dm, constructTerm(term1, dm), op, constructTerm(term2, dm), thenPart);

        System.out.println(rule);
        return r;
    }

    private ITerm constructTerm(String term, DeviceManager dm) {
        ITerm termObj;
        if (isObjectMethod(term)) {
            String[] parts = term.split(":");
            String object = parts[0];
            String method = parts[1];
            termObj = new Term(dm.searchComponent(object), method);
        } else {
            float f = Float.parseFloat(term);
            termObj = new ValueTerm(f);
        }
        return termObj;
    }

    private boolean isObjectMethod(String s) {
        if (s.indexOf(":") != -1) {
            return true;
        }
        return false;
    }
}
