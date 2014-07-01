package be.vub.smappeerules.core;

import android.app.Application;
import android.content.Context;

import java.io.IOException;
import java.util.List;

import be.vub.smappeerules.API.SmappeeAPI;
import be.vub.smappeerules.core.device.DeviceGroup;
import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.device.IDeviceComponent;
import be.vub.smappeerules.core.rule.ITerm;
import be.vub.smappeerules.core.rule.Rule;
import be.vub.smappeerules.core.rule.RuleManager;
import be.vub.smappeerules.core.rule.Term;
import be.vub.smappeerules.core.rule.ValueTerm;

/**
 * Created by Jonas on 30/06/2014.
 */

public class CoreFacade{
    private static CoreFacade OurInstance = null;

    public synchronized static CoreFacade getInstance(Context ctx){
        if( OurInstance == null)
        try {
            OurInstance = new CoreFacade(ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }
   return OurInstance;
    }

    SmappeeAPI api;
    DeviceManager dm;
    RuleManager rm;

    public CoreFacade() {}

    public CoreFacade(Context ctx) throws IOException {
        api = new SmappeeAPI();
        dm = new DeviceManager(api, ctx);
        rm = new RuleManager(dm, ctx);
    }



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

    public List<IDeviceComponent> getAllComponents() {
        return dm.getAllComponents();
    }

    public void addGroup(DeviceGroup g) {
        dm.addGroup(g);
    }

    public void removeGroup(DeviceGroup g) {
        dm.removeGroup(g);
    }

}
