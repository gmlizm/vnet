package com.aboo.vnet.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.aboo.vnet.support.AuthUserService;

@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthUserService authUserService;

	@Autowired
	private DataSource dataSource;

	/** JDBC TOKEN STORE */
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
			.userDetailsService(authUserService)// 若无，refresh_token会有UserDetailsService is required错误
			.tokenStore(tokenStore());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.jdbc(dataSource);//.withClient("testclient").secret("testclient")
//		.authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("app")
//		.authorities("testauth")
//		.and()
//		.withClient("webclient").scopes("webappscope").authorizedGrantTypes("implicit")
//		.authorities("testweb");
		
		clients.inMemory().withClient("testclient").secret("testclient")
		.authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("app")//.authorities("app")
		.and()
		.withClient("webclient").scopes("webappscope").authorizedGrantTypes("implicit");//.authorities("test");
		;
	}
	
}