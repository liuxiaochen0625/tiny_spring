package com.reus.tinyioc.step5;

/**
 * 从配置中读取BeanDefinitionReader
 * @author yihua.huang@dianping.com
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
