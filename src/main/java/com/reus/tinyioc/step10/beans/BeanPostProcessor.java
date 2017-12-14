package com.reus.tinyioc.step10.beans;

/**
 * @author reus
 * @version $Id: BeanPostProcessor.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}