package com.reus.tinyioc.step10.context;

import com.reus.tinyioc.step10.HelloWorldService;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: ApplicationContextTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc7.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext
            .getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPostBeanProcessor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "tinyioc-postbeanprocessor2.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext
            .getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
