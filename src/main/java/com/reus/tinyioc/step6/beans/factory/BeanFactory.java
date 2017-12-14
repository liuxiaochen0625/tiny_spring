package com.reus.tinyioc.step6.beans.factory;

/**
 * @author reus
 * @version $Id: BeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
