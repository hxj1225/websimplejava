package com.hxj.websimplejava.workflow;

import java.util.List;
import java.util.Map;

/**
 * ���̽ӿ�
 * 
 * @author xiangjun.hexj
 */
public interface Processor {

    /**
     * ��������
     */
    public void doActivities();

    /**
     * ��������
     * 
     * @param seedObject
     */
    public void doActivities(Map<String, Object> seedObject);

    /**
     * ��������
     * 
     * @param activities
     */
    public void setActivities(List<Activitiy> activities);

    /**
     * ����Ĭ���쳣�������
     */
    public void setDefaultErrorHandler();

}
