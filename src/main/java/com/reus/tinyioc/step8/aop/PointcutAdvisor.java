package com.reus.tinyioc.step8.aop;

/**
 * @author yihua.huang@dianping.com
 */
public interface PointcutAdvisor extends Advisor{

   Pointcut getPointcut();
}
