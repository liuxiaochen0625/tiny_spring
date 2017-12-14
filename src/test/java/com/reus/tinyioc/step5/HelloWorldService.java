package com.reus.tinyioc.step5;

/**
 * @author reus
 * @version $Id: HelloWorldService.java, v 0.1 2017-12-14 reus Exp $
 */
public class HelloWorldService {

    private String        text;

    private OutputService outputService;

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
