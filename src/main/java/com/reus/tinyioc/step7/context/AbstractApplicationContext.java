package com.reus.tinyioc.step7.context;


import com.reus.tinyioc.step7.beans.factory.AbstractBeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
