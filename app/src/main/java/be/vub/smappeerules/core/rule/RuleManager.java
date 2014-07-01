package be.vub.smappeerules.core.rule;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.device.IDeviceComponent;
import be.vub.smappeerules.core.rule.io.RuleFile;

/**
 * Created by Jonas on 30/06/2014.
 *
 *
 * Reads+interprets rule file.
 * Writes new rule to rule file.
 * Removes rule from rule file.
 *
 */
public class RuleManager {
    // Text file with rules //TODO change for android
    RuleFile file;

    DeviceManager dm;
    RuleInterpreter ri = new RuleInterpreter();

    // All rules in the app
    List<Rule> allRules = new ArrayList<Rule>();

    public RuleManager(DeviceManager dm, Context ctx) {
        this.dm = dm;
        this.file = new RuleFile("rules.txt", ctx);
        this.initAllRules();
    }

    private void initAllRules() {
        file.readRules(this);
    }

    public void processRule(String rule) {
        Rule r = ri.interpretRule(rule, dm);
        allRules.add(r);
    }

    // Returns all rules
    public List<Rule> getAllRules() {
        return allRules;
    }

    // Adds a new rule
    public void addNewRule(Rule r) {
        allRules.add(r);
        file.addNewRule(r.toRuleString());
    }

    // Removes a rule
    public void removeRule(Rule r) {
        allRules.remove(r);
        file.removeAllRules();
        for (int i = 0; i < allRules.size(); i++) {
            file.addNewRule(allRules.get(i).toRuleString());
        }
    }

    // Checks all rules.
    // If return list is empty, no alerts need to be given.
    public List<String> checkRules() {
        List<String> alertList = new ArrayList<String>();
        for (int i = 0; i < allRules.size(); i++) {
            if(allRules.get(i).isTrue())
                alertList.add(allRules.get(i).getAlert());
        }
        return alertList;
    }

}
