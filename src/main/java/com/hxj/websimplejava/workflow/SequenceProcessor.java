package com.hxj.websimplejava.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceProcessor extends BaseProcessor {

    @Override
    public void doActivities() {
        this.doActivities(null);
    }

    @Override
    public void doActivities(Map<String, Object> seedData) {
        List<Activitiy> actitities = getActivities();
        ProcessContext context = new ProcessContext(new HashMap<String, Object>());
        if (seedData != null) {
            context.set(seedData);
        }

        for (Activitiy activitiy : actitities) {
            activitiy.execute(context);
        }
        context.clear();
    }

    @Override
    public void setDefaultErrorHandler() {
    }

}
