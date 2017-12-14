package com.reus.tinyioc.step2;

import com.reus.tinyioc.step2.factory.AutowireCapableBeanFactory;
import com.reus.tinyioc.step2.factory.BeanFactory;
import org.junit.Test;


/**
 * @author yihua.huang@dianping.com
 */
public class BeanFactoryTest {

	@Test
	public void test() {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		// 2.注入bean
		BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.reus.tinyioc.step2.HelloWorldService");
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
