package com.aboo.vnet.service.client.tb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemInfoGetResponse;

@Service
public class TbTestClient {
	/**
	 * https://oauth.taobao.com/authorize?spm=a219a.7629140.0.0.vWeMHB&client_id=23620627&response_type=token
	 * 
	 * session: 61011128d0f53a1f032e11d5286e61e89511eec02f9efcb389237674
refresh_token: 6102a1284b14573f183d1ea90d5fa26c810c0ba0d02c46f389237674
	 */

	private final String tbUrl = "http://gw.api.taobao.com/router/rest";
	
	@Value("${app.tb.app-key}")
	private String appKey;
	
	@Value("${app.tb.app-secret}")
	private String appSecret;
	
	public String test() throws Exception{
		TaobaoClient client = new DefaultTaobaoClient(tbUrl, appKey, appSecret);
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setPlatform(1L);
		req.setNumIids("123,456");
		TbkItemInfoGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
}
