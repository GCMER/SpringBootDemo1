//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface _Proxy7Service extends Service {
    String getTCM_RC_03Address();

    _Proxy7 getTCM_RC_03() throws ServiceException;

    _Proxy7 getTCM_RC_03(URL var1) throws ServiceException;
}
