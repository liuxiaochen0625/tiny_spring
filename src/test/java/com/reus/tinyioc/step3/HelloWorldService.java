package com.reus.tinyioc.step3;

/**
 * @author reus
 * @version $Id: HelloWorldService.java, v 0.1 2017-12-14 reus Exp $
 */
public class HelloWorldService {

    private String text;

    public void helloWorld() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
