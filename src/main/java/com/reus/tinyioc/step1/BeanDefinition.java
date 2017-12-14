package com.reus.tinyioc.step1;

/**
 * @author reus
 * @version $Id: BeanDefinition.java, v 0.1 2017-12-14 reus Exp $
 */

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
