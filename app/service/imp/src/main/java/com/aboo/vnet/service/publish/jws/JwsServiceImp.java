package com.aboo.vnet.service.publish.jws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.stereotype.Component;

@Component
@WebService(serviceName="jwsService")
@SOAPBinding(style=Style.RPC)
public class JwsServiceImp implements JwsService {

	public String hello() {
		return "cxfServiceTest";
	}

}
