package com.reus.tinyioc.step6.beans.xml;

import com.reus.tinyioc.step6.beans.BeanDefinition;
import com.reus.tinyioc.step6.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;


import java.util.Map;

/**
 * @author yihua.huang@dianping.com
 */
public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc3.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}
}
