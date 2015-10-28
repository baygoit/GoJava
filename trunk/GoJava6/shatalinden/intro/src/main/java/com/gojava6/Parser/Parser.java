package com.gojava6.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by shata on 23.09.2015.
 */
public class Parser {

    Set<Emploee> emploies = new TreeSet<>();

    public void parse(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        while((s = reader.readLine())!=null) {
            StringTokenizer tekinazier = new StringTokenizer(s, ";");
            int id = Integer.valueOf(tekinazier.nextToken());
            String name = tekinazier.nextToken();
            int managerID = Integer.valueOf(tekinazier.nextToken());
            Emploee emploee = new Emploee(id,name,managerID);
            emploies.add(emploee);
        }

    }

}