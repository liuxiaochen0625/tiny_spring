package com.reus.tinyioc.step6.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author reus
 * @version $Id: Resource.java, v 0.1 2017-12-14 reus Exp $
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
