package com.reus.tinyioc.step8.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 * @author reus
 * @version $Id: AdvisedSupport.java, v 0.1 2017-12-14 reus Exp $
 */
public class AdvisedSupport {

    private TargetSource      targetSource;

    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
