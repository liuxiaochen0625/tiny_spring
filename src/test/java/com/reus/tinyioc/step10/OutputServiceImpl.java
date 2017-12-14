package com.reus.tinyioc.step10;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputServiceImpl implements OutputService {

    private HelloWorldService helloWorldService;

    @Override
    public void output(String text){
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
