package com.aboo.vnet.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.aboo.vapp.service.api.HelloServiceApi;

@FeignClient(value="vapp", fallback=HelloServiceFallback.class)
public interface IHelloService extends HelloServiceApi {
	
}
