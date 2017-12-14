package com.reus.tinyioc.step9.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author reus
 * @version $Id: JdkDynamicAopProxy.java, v 0.1 2017-12-14 reus Exp $
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),
            advised.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(final Object proxy, final Method method,
                         final Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        if (advised.getMethodMatcher() != null && advised.getMethodMatcher().matches(method,
            advised.getTargetSource().getTarget().getClass())) {
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(
                advised.getTargetSource().getTarget(), method, args));
        } else {
            return method.invoke(advised.getTargetSource().getTarget(), args);
        }
    }

}
