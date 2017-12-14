package com.reus.tinyioc.step2.factory;

import com.reus.tinyioc.step2.BeanDefinition;

/**
 * @author reus
 * @version $Id: AutowireCapableBeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
