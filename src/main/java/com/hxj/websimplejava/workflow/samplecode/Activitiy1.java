package com.hxj.websimplejava.workflow.samplecode;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.hxj.websimplejava.workflow.Activitiy;
import com.hxj.websimplejava.workflow.ProcessContext;

public class Activitiy1 extends Activitiy {

    @Override
    public void execute(ProcessContext context) {
        System.out.println("Œ“ «activitiy 1");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("random" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
        context.set(param);

    }

}
