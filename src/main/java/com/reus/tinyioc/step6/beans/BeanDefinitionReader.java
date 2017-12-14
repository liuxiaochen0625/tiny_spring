package com.reus.tinyioc.step6.beans;

/**
 * @author reus
 * @version $Id: BeanDefinitionReader.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
