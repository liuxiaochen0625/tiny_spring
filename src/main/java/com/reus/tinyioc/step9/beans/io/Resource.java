package com.reus.tinyioc.step9.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。
 * @author yihua.huang@dianping.com
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
