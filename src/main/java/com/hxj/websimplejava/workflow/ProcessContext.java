package com.hxj.websimplejava.workflow;

import java.util.Map;

/**
 * @author xiangjun.hexj
 */
public class ProcessContext {

    private Map<String, Object> context;

    public ProcessContext(Map<String, Object> context){
        this.context = context;
    }

    public void set(Map<String, Object> context) {
        context.putAll(context);
    }

    public Object get(String name) {
        return context.get(name);
    }

    public void add(String name, Object value) {
        context.put(name, value);
    }

    public void clear() {
        context.clear();
    }
}
