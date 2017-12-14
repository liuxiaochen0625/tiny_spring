package com.reus.tinyioc.step8.aop;

import com.reus.tinyioc.step8.HelloWorldService;
import com.reus.tinyioc.step8.context.ApplicationContext;
import com.reus.tinyioc.step8.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: JdkDynamicAopProxyTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc5.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext
            .getBean("helloWorldService");
        helloWorldService.helloWorld();

        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy
            .getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.helloWorld();

    }
}
