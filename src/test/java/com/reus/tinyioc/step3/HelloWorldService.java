package com.reus.tinyioc.step3;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloWorldService {

    private String text;

    public void helloWorld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
