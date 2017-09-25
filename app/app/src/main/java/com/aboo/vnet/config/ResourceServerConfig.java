package com.aboo.vnet.config;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	/** JDBC TOKEN STORE */
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.authenticationManager(authenticationManager).tokenStore(tokenStore());
	}
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            	.anonymous().disable()
                .httpBasic();
    	
//    	http/*.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
//    	.and()
//    	.logout().invalidateHttpSession(true).clearAuthentication(true).permitAll()
//    	.and()*/
//    	.authorizeRequests()
//    	.antMatchers("/oauth/**").permitAll()
//        .antMatchers("/swagger*/**", "/webjars/**", "/v2/**").permitAll()
//        .antMatchers("/static/**").permitAll()
//        .anyRequest().permitAll()//.authenticated()
//        .and()
//        .csrf().disable()
//        .exceptionHandling()
//        .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//        .and()
//        .httpBasic()
//        ;
    	
    }

    
}