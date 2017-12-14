package com.reus.tinyioc.step4;

import com.reus.tinyioc.step4.factory.AutowireCapableBeanFactory;
import com.reus.tinyioc.step4.factory.BeanFactory;
import com.reus.tinyioc.step4.io.ResourceLoader;
import com.reus.tinyioc.step4.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author reus
 * @version $Id: BeanFactoryTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
            new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
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
}
