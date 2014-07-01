package be.vub.smappeerules.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import be.vub.smappeerules.core.rule.io.RuleFile;
import be.vub.smappeerules.core.rule.RuleInterpreter;
/**
 * Created by Jonas on 30/06/2014.
 */
public class MainToTest {
    public static void main(String [] args) {
       /* RuleFile file = new RuleFile("C:\\Users\\Jonas\\Desktop\\" + "rules.txt");

        file.addNewRule("bla => bla");

        System.out.println("file?");

        RuleInterpreter ri = new RuleInterpreter();
        //file.readRules(ri);
*/
        String ifPart = "a qsdf bc";
        String[] s = ifPart.split(" .* ");
        System.out.println(s[0] + s[1]);
    }
}
