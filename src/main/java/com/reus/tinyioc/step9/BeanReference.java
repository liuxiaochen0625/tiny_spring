package com.reus.tinyioc.step9;

/**
 * @author reus
 * @version $Id: BeanReference.java, v 0.1 2017-12-14 reus Exp $
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
