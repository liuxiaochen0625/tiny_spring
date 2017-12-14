package com.reus.tinyioc.step2.factory;


import com.reus.tinyioc.step2.BeanDefinition;

/**
 * @author yihua.huang@dianping.com
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
