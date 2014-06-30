package be.vub.smappeerules.core.rule.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import be.vub.smappeerules.core.rule.RuleInterpreter;
import be.vub.smappeerules.core.rule.RuleManager;

/**
 * Created by Jonas on 30/06/2014.
 */
public class RuleFile {
    File file;
    String endLine = System.getProperty("line.separator");

    public RuleFile(String path) {
        this.file = new File(path);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addNewRule(String rule) {
        if (file.exists()) {
            try {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter out = new BufferedWriter(filewriter);
                out.write(rule + endLine);
                out.flush();
                out.close();
                filewriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllRules() {
        if (file.exists()) {
            try {
                FileWriter filewriter = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(filewriter);
                out.write("");
                out.flush();
                out.close();
                filewriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readRules(RuleManager o) {
        if(file.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(file));
                String line;
                while ((line = in.readLine()) != null) {
                    o.processRule(line);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
