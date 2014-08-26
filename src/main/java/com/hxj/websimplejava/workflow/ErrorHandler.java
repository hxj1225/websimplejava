package com.hxj.websimplejava.workflow;

import org.springframework.beans.factory.BeanNameAware;

public interface ErrorHandler extends BeanNameAware {

    public void error(ProcessContext context, Throwable t);
}
