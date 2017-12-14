package com.reus.tinyioc.step8.beans;

/**
 * @author reus
 * @version $Id: PropertyValue.java, v 0.1 2017-12-14 reus Exp $
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
