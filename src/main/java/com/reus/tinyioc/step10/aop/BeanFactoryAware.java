package com.reus.tinyioc.step10.aop;


import com.reus.tinyioc.step10.beans.factory.BeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
