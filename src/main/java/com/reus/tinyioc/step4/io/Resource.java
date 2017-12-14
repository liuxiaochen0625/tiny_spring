package com.reus.tinyioc.step4.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。
 * @author reus
 * @version $Id: Resource.java, v 0.1 2017-12-14 reus Exp $
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
