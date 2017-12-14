package com.reus.tinyioc.step7.beans.factory;

/**
 * bean的容器
 * @author yihua.huang@dianping.com
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
