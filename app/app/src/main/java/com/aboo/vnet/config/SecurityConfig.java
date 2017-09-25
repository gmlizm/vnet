package com.aboo.vnet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.aboo.vnet.support.AuthUserService;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthUserService authUserService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
		auth.userDetailsService(authUserService);//.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {  
    	http.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
    	.and()
    	.logout().invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID").permitAll()
    	.and()
    	.authorizeRequests()
    	.antMatchers("/oauth/**").permitAll()
        .antMatchers("/swagger*/**", "/webjars/**", "/v2/**").permitAll()
        .antMatchers("/static/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf().disable()
        .httpBasic()
        ;
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/swagger*/**", "/webjars/**");
	}
	
	/**--------------------------------------Oauth2----------------------------------------------------*/
    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
}
