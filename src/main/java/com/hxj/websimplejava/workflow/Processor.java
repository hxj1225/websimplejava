package com.hxj.websimplejava.workflow;

import java.util.List;
import java.util.Map;

/**
 * 流程接口
 * 
 * @author xiangjun.hexj
 */
public interface Processor {

    /**
     * 启动流程
     */
    public void doActivities();

    /**
     * 启动流程
     * 
     * @param seedObject
     */
    public void doActivities(Map<String, Object> seedObject);

    /**
     * 设置流程
     * 
     * @param activities
     */
    public void setActivities(List<Activitiy> activities);

    /**
     * 设置默认异常处理机制
     */
    public void setDefaultErrorHandler();

}
