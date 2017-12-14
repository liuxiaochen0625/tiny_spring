package com.reus.tinyioc.step1;

/**
 * @author yihua.huang@dianping.com
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
