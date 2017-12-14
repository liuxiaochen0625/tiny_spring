package com.reus.tinyioc.step4.factory;

import com.reus.tinyioc.step4.BeanDefinition;

/**
 * bean的容器
 * @author reus
 * @version $Id: BeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
