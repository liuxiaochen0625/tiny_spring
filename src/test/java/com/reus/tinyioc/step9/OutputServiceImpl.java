package com.reus.tinyioc.step9;

import org.junit.Assert;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputServiceImpl implements OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

}
