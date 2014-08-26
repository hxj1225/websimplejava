package com.hxj.websimplejava.workflow;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.CollectionUtils;

/**
 * @author xiangjun.hexj
 */
public abstract class BaseProcessor implements Processor, InitializingBean, ApplicationContextAware {

    private List<Activitiy>    activities;
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(activities)) {
            throw new Exception("No activities were wired for this workflow");
        }
    }

    public void setActivities(List<Activitiy> activities) {
        this.activities = activities;
    }

    public List<Activitiy> getActivities() {
        return activities;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
