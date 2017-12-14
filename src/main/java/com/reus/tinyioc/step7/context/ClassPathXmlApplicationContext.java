package com.reus.tinyioc.step7.context;

import com.reus.tinyioc.step7.beans.BeanDefinition;
import com.reus.tinyioc.step7.beans.factory.AbstractBeanFactory;
import com.reus.tinyioc.step7.beans.factory.AutowireCapableBeanFactory;
import com.reus.tinyioc.step7.beans.io.ResourceLoader;
import com.reus.tinyioc.step7.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author reus
 * @version $Id: ClassPathXmlApplicationContext.java, v 0.1 2017-12-14 reus Exp $
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,
                                          AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
            new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader
            .getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),
                beanDefinitionEntry.getValue());
        }
    }

}
