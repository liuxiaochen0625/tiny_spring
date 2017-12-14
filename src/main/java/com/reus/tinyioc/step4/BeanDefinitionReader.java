package com.reus.tinyioc.step4;

/**
 * 从配置中读取BeanDefinitionReader
 * @author reus
 * @version $Id: BeanDefinitionReader.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
