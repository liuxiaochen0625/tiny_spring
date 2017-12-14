package com.reus.tinyioc.step9.beans.factory;

import com.reus.tinyioc.step9.BeanReference;
import com.reus.tinyioc.step9.aop.BeanFactoryAware;
import com.reus.tinyioc.step9.beans.BeanDefinition;
import com.reus.tinyioc.step9.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author reus
 * @version $Id: AutowireCapableBeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass()
                    .getDeclaredMethod("set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                       + propertyValue.getName().substring(1),
                        value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
