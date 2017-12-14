package com.reus.tinyioc.step4.xml;

import com.reus.tinyioc.step4.BeanDefinition;
import com.reus.tinyioc.step4.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author reus
 * @version $Id: XmlBeanDefinitionReaderTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
            new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }
}
