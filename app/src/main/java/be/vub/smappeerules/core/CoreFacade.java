package be.vub.smappeerules.core;

import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.core.device.DeviceGroup;
import be.vub.smappeerules.core.device.DeviceManager;
import be.vub.smappeerules.core.device.IDeviceComponent;
import be.vub.smappeerules.core.rule.RuleInterpreter;
import be.vub.smappeerules.core.rule.RuleManager;
import be.vub.smappeerules.core.rule.io.RuleFile;
import be.vub.smappeerules.core.rule.Rule;

/**
 * Created by Jonas on 30/06/2014.
 */

public class CoreFacade {
    //TODO geef de nodige functies van RuleManager en DeviceManager door aan UI

    DeviceManager dm = new DeviceManager();
    RuleManager rm = new RuleManager(dm);

    public void checkRules() {
        rm.checkRules();
    }
}
