package com.reus.tinyioc.step10.aop;

/**
 * @author reus
 * @version $Id: PointcutAdvisor.java, v 0.1 2017-12-14 reus Exp $
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
