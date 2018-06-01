//package com.aboo.vnet.config;
//
//import javax.xml.ws.Endpoint;
//
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.aboo.vnet.service.ws.service.HelloService;
//
//@Configuration
//public class WsCXFConfig {
//
//	@Autowired
//    private Bus bus;
//	
//	@Autowired
//	private HelloService helloService;
// 
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(bus, helloService);
//        endpoint.publish("/helloService");
//        return endpoint;
//    }
//}
