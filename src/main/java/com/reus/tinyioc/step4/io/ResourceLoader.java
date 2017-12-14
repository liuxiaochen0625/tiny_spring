package com.reus.tinyioc.step4.io;

import java.net.URL;

/**
 * @author yihua.huang@dianping.com
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
