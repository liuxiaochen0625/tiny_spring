package com.reus.tinyioc.step10.aop;

/**
 * @author reus
 * @version $Id: ProxyFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        return new Cglib2AopProxy(this);
    }
}
