package com.reus.tinyioc.step9.aop;

import org.aopalliance.aop.Advice;

/**
 * @author yihua.huang@dianping.com
 */
public interface Advisor {

    Advice getAdvice();
}
