package com.reus.tinyioc.step4.factory;

import com.reus.tinyioc.step4.BeanDefinition;

/**
 * bean的容器
 * @author yihua.huang@dianping.com
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
