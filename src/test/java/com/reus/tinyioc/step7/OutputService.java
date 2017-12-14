package com.reus.tinyioc.step7;

import org.junit.Assert;

/**
 * @author reus
 * @version $Id: OutputService.java, v 0.1 2017-12-14 reus Exp $
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text) {
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
