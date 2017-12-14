package com.reus.tinyioc.step8.beans;

/**
 * 从配置中读取BeanDefinition
 * @author yihua.huang@dianping.com
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
