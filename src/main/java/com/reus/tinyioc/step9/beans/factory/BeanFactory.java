package com.reus.tinyioc.step9.beans.factory;

/**
 * @author reus
 * @version $Id: BeanFactory.java, v 0.1 2017-12-14 reus Exp $
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
