package com.reus.tinyioc.step10.aop;

import java.lang.reflect.Method;

/**
 * @author reus
 * @version $Id: MethodMatcher.java, v 0.1 2017-12-14 reus Exp $
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
