package com.reus.tinyioc.step9;

import com.reus.tinyioc.step9.beans.BeanPostProcessor;

/**
 * @author reus
 * @version $Id: BeanInitializeLogger.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}
