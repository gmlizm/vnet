package com.aboo.vnet.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class WebServiceConfig {
	
	@Bean  
    public SimpleJaxWsServiceExporter jaxWsExporter(ApplicationContext applicationContext) {  
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();  
        exporter.setBaseAddress("http://localhost:8081/services/"); 
//        exporter.setBeanFactory(applicationContext);
        return exporter; 
    }  
	
//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/services/*");
//    }
	
//	@Bean(name = "countries")
//	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
//		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
//		wsdl.setPortTypeName("CountriesPort");
//		wsdl.setLocationUri("/services");
//		wsdl.setTargetNamespace("http://localhost:8080/services");
//		wsdl.setSchema(schema);
//		return wsdl;
//	}
//	
//    @Bean
//    public XsdSchema countriesSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("/META-INF/schemas/countries.xsd"));
//    }
	
}
