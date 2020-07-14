package rpc_helloworld;

import java.net.MalformedURLException;
import java.net.URL;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;

public class RPC_HelloWorld {
    
    public static void main(String[] args) {

        try {
            //Refer to wsdl document
            URL url = new URL("http://localhost:7779/ws/hello?wsdl");
            
            //Refer to wsdl document 
            QName qname = new QName("http://rpc_helloworld/", "HelloWorldImplService");  

            Service service = Service.create(url, qname);  
            HelloWorld hello = service.getPort(HelloWorld.class);
            
            System.out.println(hello.getHelloWorld("Hello World!"));
        
        } catch (MalformedURLException ex) {
            System.out.println("WSDL document url error: " + ex);
        }
    } 
}
