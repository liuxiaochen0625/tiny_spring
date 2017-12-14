package com.reus.tinyioc.step6.beans;

import com.reus.tinyioc.step6.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reus
 * @version $Id: AbstractBeanDefinitionReader.java, v 0.1 2017-12-14 reus Exp $
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader              resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
