package com.reus.tinyioc.step10;

/**
 * @author reus
 * @version $Id: OutputServiceImpl.java, v 0.1 2017-12-14 reus Exp $
 */
public class OutputServiceImpl implements OutputService {

    private HelloWorldService helloWorldService;

    @Override
    public void output(String text) {
        System.out.println(text);
    }

    /**
     * Setter method for property <tt>helloWorldService</tt>.
     *
     * @param helloWorldService value to be assigned to property helloWorldService
     */
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
