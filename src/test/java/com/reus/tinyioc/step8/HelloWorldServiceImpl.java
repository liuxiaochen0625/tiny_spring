package com.reus.tinyioc.step8;

/**
 * @author reus
 * @version $Id: HelloWorldServiceImpl.java, v 0.1 2017-12-14 reus Exp $
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private String        text;

    private OutputService outputService;

    @Override
    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
