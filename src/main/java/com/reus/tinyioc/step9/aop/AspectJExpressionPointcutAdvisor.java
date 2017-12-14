package com.reus.tinyioc.step9.aop;

import org.aopalliance.aop.Advice;

/**
 * @author reus
 * @version $Id: AspectJExpressionPointcutAdvisor.java, v 0.1 2017-12-14 reus Exp $
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice                    advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
