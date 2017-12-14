package com.reus.tinyioc.step6.context;

import com.reus.tinyioc.step6.HelloWorldService;
import org.junit.Test;


/**
 * @author yihua.huang@dianping.com
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc3.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
