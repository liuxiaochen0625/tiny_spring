package com.reus.tinyioc.step8;

import java.util.Map;

import com.reus.tinyioc.step8.beans.BeanDefinition;
import com.reus.tinyioc.step8.beans.factory.AbstractBeanFactory;
import com.reus.tinyioc.step8.beans.factory.AutowireCapableBeanFactory;
import com.reus.tinyioc.step8.beans.io.ResourceLoader;
import com.reus.tinyioc.step8.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: BeanFactoryTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
            new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc5.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader
            .getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),
                beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory
            .getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
            new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc5.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader
            .getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),
                beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory
            .getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
