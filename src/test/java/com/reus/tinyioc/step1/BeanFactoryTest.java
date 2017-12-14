package com.reus.tinyioc.step1;

import org.junit.Test;

/**
 * @author reus
 * @version $Id: BeanFactoryTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory
            .getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
