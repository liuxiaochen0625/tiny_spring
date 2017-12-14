package com.reus.tinyioc.step3.factory;


import com.reus.tinyioc.step3.BeanDefinition;

/**
 * bean的容器
 * @author yihua.huang@dianping.com
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
