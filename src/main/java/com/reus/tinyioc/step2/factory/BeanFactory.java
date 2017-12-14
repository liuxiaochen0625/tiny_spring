package com.reus.tinyioc.step2.factory;

import com.reus.tinyioc.step2.BeanDefinition;

/**
 * @author reus
 * @version $Id: BeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
