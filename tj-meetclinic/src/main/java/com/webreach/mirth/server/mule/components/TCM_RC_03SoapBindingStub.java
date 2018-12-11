//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

public class TCM_RC_03SoapBindingStub extends Stub implements _Proxy7 {
    private Vector cachedSerClasses;
    private Vector cachedSerQNames;
    private Vector cachedSerFactories;
    private Vector cachedDeserFactories;
    static OperationDesc[] _operations = new OperationDesc[1];

    private static void _initOperationDesc1() {
        OperationDesc oper = new OperationDesc();
        oper.setName("acceptMessage");
        ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("", "acceptMessageReturn"));
        oper.setStyle(Style.RPC);
        oper.setUse(Use.ENCODED);
        _operations[0] = oper;
    }

    public TCM_RC_03SoapBindingStub() throws AxisFault {
        this((Service)null);
    }

    public TCM_RC_03SoapBindingStub(URL endpointURL, Service service) throws AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public TCM_RC_03SoapBindingStub(Service service) throws AxisFault {
        this.cachedSerClasses = new Vector();
        this.cachedSerQNames = new Vector();
        this.cachedSerFactories = new Vector();
        this.cachedDeserFactories = new Vector();
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }

        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
    }

    protected Call createCall() throws RemoteException {
        try {
            Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }

            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }

            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }

            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }

            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }

            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }

            Enumeration keys = super.cachedProperties.keys();

            while(keys.hasMoreElements()) {
                String key = (String)keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }

            return _call;
        } catch (Throwable var4) {
            throw new AxisFault("Failure trying to get the Call object", var4);
        }
    }

    public String acceptMessage(String in0) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[0]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("");
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("http://DefaultNamespace", "acceptMessage"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{in0});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (String)_resp;
                    } catch (Exception var5) {
                        return (String)JavaUtils.convert(_resp, String.class);
                    }
                }
            } catch (AxisFault var6) {
                throw var6;
            }
        }
    }

    static {
        _initOperationDesc1();
    }
}
