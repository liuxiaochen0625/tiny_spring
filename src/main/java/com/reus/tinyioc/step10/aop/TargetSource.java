package com.reus.tinyioc.step10.aop;

/**
 * @author reus
 * @version $Id: TargetSource.java, v 0.1 2017-12-14 reus Exp $
 */
public class TargetSource {

    private Class<?>   targetClass;

    private Class<?>[] interfaces;

    private Object     target;

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
