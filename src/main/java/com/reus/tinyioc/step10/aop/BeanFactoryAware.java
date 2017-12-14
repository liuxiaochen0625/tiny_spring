package com.reus.tinyioc.step10.aop;

import com.reus.tinyioc.step10.beans.factory.BeanFactory;

/**
 * @author reus
 * @version $Id: BeanFactoryAware.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
