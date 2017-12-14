package com.reus.tinyioc.step9.aop;


import com.reus.tinyioc.step9.beans.factory.BeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
