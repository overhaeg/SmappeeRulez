package be.vub.smappeerules.core.rule;

import java.util.ArrayList;
import java.util.List;

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
    RuleFile file = new RuleFile("C:\\Users\\Jonas\\Desktop\\" + "rules.txt");

    RuleInterpreter ri = new RuleInterpreter();

    // All rules in the app
    List<Rule> allRules = new ArrayList<Rule>();

    private void initAllRules() {
        file.readRules(this);
    }

    public void processRule(String rule) {
        Rule r = ri.interpretRule(rule);
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

    //TODO als vanuit UI geen Rule object gegeven mag worden... soort van String-based lookup doen van een rule in de allRules om te removen
}
