package com.reus.tinyioc.step9.aop;

/**
 * @author reus
 * @version $Id: Pointcut.java, v 0.1 2017-12-14 reus Exp $
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
