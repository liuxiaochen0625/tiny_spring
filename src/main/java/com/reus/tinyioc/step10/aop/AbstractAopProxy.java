package com.reus.tinyioc.step10.aop;

/**
 * @author reus
 * @version $Id: AbstractAopProxy.java, v 0.1 2017-12-14 reus Exp $
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
