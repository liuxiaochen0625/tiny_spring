package com.reus.tinyioc.step7.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author reus
 * @version $Id: TimerInterceptor.java, v 0.1 2017-12-14 reus Exp $
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation of Method " + invocation.getMethod().getName() + " start!");
        Object proceed = invocation.proceed();
        System.out.println("Invocation of Method " + invocation.getMethod().getName()
                           + " end! takes " + (System.nanoTime() - time) + " nanoseconds.");
        return proceed;
    }
}
