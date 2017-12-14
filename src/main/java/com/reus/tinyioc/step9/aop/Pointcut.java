package com.reus.tinyioc.step9.aop;

/**
 * @author yihua.huang@dianping.com
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
