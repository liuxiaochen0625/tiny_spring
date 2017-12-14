package com.reus.tinyioc.step10.aop;

import org.aopalliance.aop.Advice;

/**
 * @author reus
 * @version $Id: Advisor.java, v 0.1 2017-12-14 reus Exp $
 */
public interface Advisor {

    Advice getAdvice();
}
