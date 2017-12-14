package com.reus.tinyioc.step7.aop;

/**
 * 被代理的对象
 * @author reus
 * @version $Id: TargetSource.java, v 0.1 2017-12-14 reus Exp $
 */
public class TargetSource {

    private Class  targetClass;

    private Object target;

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
