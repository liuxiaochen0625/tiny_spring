package com.reus.tinyioc.step7.context;

import com.reus.tinyioc.step7.HelloWorldService;
import org.junit.Test;

/**
 * @author reus
 * @version $Id: ApplicationContextTest.java, v 0.1 2017-12-14 reus Exp $
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc4.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext
            .getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
