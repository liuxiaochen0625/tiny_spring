package com.reus.tinyioc.step9.aop;

/**
 * @author reus
 * @version $Id: ClassFilter.java, v 0.1 2017-12-14 reus Exp $
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
