package be.vub.smappeerules.core.rule;

import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.device.IDeviceComponent;

/**
 * Created by Jonas on 30/06/2014.
 */

public class RuleInterpreter {
    public Rule interpretRule(String rule, DeviceManager dm) {
        // TODO moet hier eig niet geevalueerd worden!!

        //TODO Parse ...->...
        //TODO Parse ...<OP>... (Term1, Term2)
        //TODO gebruikt rulelist om geinterpreteerde rules aan ruleList toe te voegen

        Rule r = new Rule();
        //Rule r = new Rule(dm ... );
        /*//...
        float f1;
        //TODO maak aparte methode voor wat hier staat
        if(isObjectMethod(term1)) {
            String[] parts = term1.split(":");
            String object = parts[0];
            String method = parts[1];
            IDeviceComponent c = "lookupDevice(parts[0])"; //TODO Audrey in device manager (moet ik hier ook aankunnen, dus ergens globaal voorlopig
            Term term = new Term(c, parts[1]);
            f1 = term.evaluate();
        } else {
            f1 = Float.parseFloat(term1);
            //TODO
        }

        if(op.equals("<"))
            e1 < e2*/

        System.out.println(rule);
        return r;
    }

    private ITerm constructTerm(String term, DeviceManager dm) {
        ITerm termObj;
        if (isObjectMethod(term)) {
            String[] parts = term.split(":");
            String object = parts[0];
            String method = parts[1];
            IDeviceComponent c = dm.searchComponent(parts[0]);
            termObj = new Term(c, parts[1]);
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
