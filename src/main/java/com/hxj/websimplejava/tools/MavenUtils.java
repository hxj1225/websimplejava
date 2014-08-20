/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.TreeMultiset;

/**
 * 类MavenUtils.java的实现描述：TODO 类实现描述
 * 
 * @author xiangjun.hexj 2014年1月23日 下午2:49:55
 */
public class MavenUtils {

    /**
     * 生成maven dependency:tree文件名
     */
    private final static String  MAVEN_FILENAME     = "maven.txt";

    private List<String>         excludes           = Arrays.asList("\\[INFO\\]", "\\|", "\\+-", "\\\\-");

    private final static String  COLON              = ":";

    private Set<MavenDependency> mavenDependencySet = new HashSet<MavenDependency>();
    private Set<String>          lineSet            = new HashSet<String>();

    private Set<String>          conflictSet        = new HashSet<String>();

    public void createMavenDependencyTreeFile() throws IOException {
        StringBuffer cmdStringBuffer = new StringBuffer("mvn.bat dependency:tree");
        cmdStringBuffer.append(" > ");
        cmdStringBuffer.append(MAVEN_FILENAME);
        Runtime.getRuntime().exec(cmdStringBuffer.toString());
    }

    public void readMavenFile() throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(MAVEN_FILENAME);
            if (!file.exists()) {
                return;
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                MavenDependency mavenDependency = this.reject(line);
                if (mavenDependency != null) {
                    mavenDependencySet.add(mavenDependency);
                }
            }
        } finally {
            if (fileReader != null) fileReader.close();
            if (bufferedReader != null) bufferedReader.close();
        }
    }

    /**
     * 剔除无用的信息
     * 
     * @param line
     * @return
     */
    public MavenDependency reject(String line) {
        for (String exclude : excludes) {
            line = line.replaceAll(exclude, "");
        }
        String[] splitLine = line.split(COLON);
        MavenDependency mavenDependency = null;
        if (splitLine != null && splitLine.length == 5) {
            mavenDependency = new MavenDependency();
            if (splitLine[0] != null) mavenDependency.setGroupId(splitLine[0].trim());
            if (splitLine[1] != null) mavenDependency.setArtifactId(splitLine[1].trim());
            if (splitLine[2] != null) mavenDependency.setType(splitLine[2].trim());
            if (splitLine[3] != null) mavenDependency.setVersion(splitLine[3].trim());
            if (splitLine[4] != null) mavenDependency.setScope(splitLine[4].trim());

            lineSet.add(splitLine[0].trim() + COLON + splitLine[1].trim());
        }
        return mavenDependency;
    }

    public void checkMavenConflict() {
        HashMultiset<String> hashMultiset = HashMultiset.create();
        hashMultiset.addAll(lineSet);
        for (String lineString : hashMultiset) {
            int count = hashMultiset.count(lineString);
            if (count > 1) {
                conflictSet.add(lineString);
            }
        }
    }

    public static void main(String[] args) {
        MavenUtils mavenUtils = new MavenUtils();
        try {
            // mavenUtils.createMavenDependencyTreeFile();
            mavenUtils.readMavenFile();
            mavenUtils.checkMavenConflict();
            // for (MavenDependency mavenDependency : mavenUtils.mavenDependencySet) {
            // System.out.println(mavenDependency);
            // }
            Collator collator = Collator.getInstance();
            TreeMultiset<String> tree = TreeMultiset.create(collator);
            tree.addAll(mavenUtils.lineSet);
            for (String string : tree) {
                System.out.println(string);
            }
            // for (String string : mavenUtils.conflictSet) {
            // System.out.println(string);
            // }
            // System.out.println(mavenUtils.mavenDependencySet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
