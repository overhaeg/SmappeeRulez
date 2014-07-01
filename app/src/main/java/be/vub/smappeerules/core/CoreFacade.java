package be.vub.smappeerules.core;

import java.util.List;

import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.rule.ITerm;
import be.vub.smappeerules.core.rule.Rule;
import be.vub.smappeerules.core.rule.RuleManager;
import be.vub.smappeerules.core.rule.Term;
import be.vub.smappeerules.core.rule.ValueTerm;

/**
 * Created by Jonas on 30/06/2014.
 */

public class CoreFacade {
    DeviceManager dm = new DeviceManager(); // TODO make sure dat devices geinit zijn voor aan rulemanager te geven
    RuleManager rm = new RuleManager(dm);

    public void checkRules() {
        rm.checkRules();
    }

    public void addNewRule(List<String> ruleList) {
        ITerm term1 = new Term(dm.searchComponent(ruleList.get(0)), ruleList.get(1));
        String op = ruleList.get(2);
        ITerm term2;
        String alert;
        if(ruleList.size() == 5) { //contains ValueTerm
            term2 = new ValueTerm(Float.parseFloat(ruleList.get(3)));
            alert = ruleList.get(4);
        } else { // ruleList.size() == 6  //contains Term
            term2 = new Term(dm.searchComponent(ruleList.get(3)), ruleList.get(4));
            alert = ruleList.get(5);
        }
        Rule r = new Rule(dm, term1, op, term2, alert);
        rm.addNewRule(r);
    }

    public void removeRule(Rule r) {
        rm.removeRule(r);
    }

    public void getAllRules() {
        rm.getAllRules();
    }

}
