package com.hxj.websimplejava.workflow.samplecode;

import com.hxj.websimplejava.workflow.Activitiy;
import com.hxj.websimplejava.workflow.ProcessContext;

public class Activitiy3 extends Activitiy {

    @Override
    public void execute(ProcessContext context) {
        System.out.println("����activitiy 3");
    }

}
