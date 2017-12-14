package com.reus.tinyioc.step8.beans.factory;

import com.reus.tinyioc.step8.BeanReference;
import com.reus.tinyioc.step8.beans.BeanDefinition;
import com.reus.tinyioc.step8.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author reus
 * @version $Id: AutowireCapableBeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
