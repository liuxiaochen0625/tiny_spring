package com.reus.tinyioc.step9.beans.io;

import java.net.URL;

/**
 * @author reus
 * @version $Id: ResourceLoader.java, v 0.1 2017-12-14 reus Exp $
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
