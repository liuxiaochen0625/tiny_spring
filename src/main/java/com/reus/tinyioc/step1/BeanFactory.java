package com.reus.tinyioc.step1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author reus
 * @version $Id: BeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
