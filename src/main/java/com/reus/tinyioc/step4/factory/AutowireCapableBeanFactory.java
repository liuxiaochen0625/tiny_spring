package com.reus.tinyioc.step4.factory;

import com.reus.tinyioc.step4.BeanDefinition;
import com.reus.tinyioc.step4.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可自动装配内容的BeanFactory
 * @author reus
 * @version $Id: AutowireCapableBeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
