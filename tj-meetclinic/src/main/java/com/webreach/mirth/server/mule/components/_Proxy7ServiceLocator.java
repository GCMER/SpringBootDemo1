//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

public class _Proxy7ServiceLocator extends Service implements _Proxy7Service {
    private String TCM_RC_03_address = "http://10.94.12.10:30011/services/TCM_RC_03";
    private String TCM_RC_03WSDDServiceName = "TCM_RC_03";
    private HashSet ports = null;

    public _Proxy7ServiceLocator() {
    }

    public _Proxy7ServiceLocator(EngineConfiguration config) {
        super(config);
    }

    public _Proxy7ServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    public String getTCM_RC_03Address() {
        return this.TCM_RC_03_address;
    }

    public String getTCM_RC_03WSDDServiceName() {
        return this.TCM_RC_03WSDDServiceName;
    }

    public void setTCM_RC_03WSDDServiceName(String name) {
        this.TCM_RC_03WSDDServiceName = name;
    }

    public _Proxy7 getTCM_RC_03() throws ServiceException {
        URL endpoint;
        try {
            endpoint = new URL(this.TCM_RC_03_address);
        } catch (MalformedURLException var3) {
            throw new ServiceException(var3);
        }

        return this.getTCM_RC_03(endpoint);
    }

    public _Proxy7 getTCM_RC_03(URL portAddress) throws ServiceException {
        try {
            TCM_RC_03SoapBindingStub _stub = new TCM_RC_03SoapBindingStub(portAddress, this);
            _stub.setPortName(this.getTCM_RC_03WSDDServiceName());
            return _stub;
        } catch (AxisFault var3) {
            return null;
        }
    }

    public void setTCM_RC_03EndpointAddress(String address) {
        this.TCM_RC_03_address = address;
    }

    public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (_Proxy7.class.isAssignableFrom(serviceEndpointInterface)) {
                TCM_RC_03SoapBindingStub _stub = new TCM_RC_03SoapBindingStub(new URL(this.TCM_RC_03_address), this);
                _stub.setPortName(this.getTCM_RC_03WSDDServiceName());
                return _stub;
            }
        } catch (Throwable var3) {
            throw new ServiceException(var3);
        }

        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return this.getPort(serviceEndpointInterface);
        } else {
            String inputPortName = portName.getLocalPart();
            if ("TCM_RC_03".equals(inputPortName)) {
                return this.getTCM_RC_03();
            } else {
                Remote _stub = this.getPort(serviceEndpointInterface);
                ((Stub)_stub).setPortName(portName);
                return _stub;
            }
        }
    }

    public QName getServiceName() {
        return new QName("http://components.mule.server.mirth.webreach.com", "_Proxy7Service");
    }

    public Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new HashSet();
            this.ports.add(new QName("http://components.mule.server.mirth.webreach.com", "TCM_RC_03"));
        }

        return this.ports.iterator();
    }

    public void setEndpointAddress(String portName, String address) throws ServiceException {
        if ("TCM_RC_03".equals(portName)) {
            this.setTCM_RC_03EndpointAddress(address);
        } else {
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        this.setEndpointAddress(portName.getLocalPart(), address);
    }
}
