package com.reus.tinyioc.step3;

import com.reus.tinyioc.step3.factory.AutowireCapableBeanFactory;
import com.reus.tinyioc.step3.factory.BeanFactory;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: BeanFactoryTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.reus.tinyioc.step3.HelloWorldService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory
            .getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
