package com.reus.tinyioc.step9.aop;

import com.reus.tinyioc.step9.HelloWorldService;
import com.reus.tinyioc.step9.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: AspectJExpressionPointcutTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.reus.tinyioc.step9.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter()
            .matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.reus.tinyioc.step9.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(
            HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),
            HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
