
package hello.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "helloservice", targetNamespace = "http://service.hello/", wsdlLocation = "http://localhost:8080/helloservice/helloservice?WSDL")
public class Helloservice_Service
    extends Service
{

    private final static URL HELLOSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOSERVICE_EXCEPTION;
    private final static QName HELLOSERVICE_QNAME = new QName("http://service.hello/", "helloservice");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/helloservice/helloservice?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOSERVICE_WSDL_LOCATION = url;
        HELLOSERVICE_EXCEPTION = e;
    }

    public Helloservice_Service() {
        super(__getWsdlLocation(), HELLOSERVICE_QNAME);
    }

    public Helloservice_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOSERVICE_QNAME, features);
    }

    public Helloservice_Service(URL wsdlLocation) {
        super(wsdlLocation, HELLOSERVICE_QNAME);
    }

    public Helloservice_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOSERVICE_QNAME, features);
    }

    public Helloservice_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Helloservice_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Helloservice
     */
    @WebEndpoint(name = "helloservicePort")
    public Helloservice getHelloservicePort() {
        return super.getPort(new QName("http://service.hello/", "helloservicePort"), Helloservice.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Helloservice
     */
    @WebEndpoint(name = "helloservicePort")
    public Helloservice getHelloservicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.hello/", "helloservicePort"), Helloservice.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOSERVICE_EXCEPTION!= null) {
            throw HELLOSERVICE_EXCEPTION;
        }
        return HELLOSERVICE_WSDL_LOCATION;
    }

}
