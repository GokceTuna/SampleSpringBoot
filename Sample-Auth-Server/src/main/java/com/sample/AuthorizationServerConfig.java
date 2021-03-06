package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String[] SCOPES_GRANTED = new String[] { "myssoclient" };
	private static final String[] SCOPES_AUTO_APPROVED = new String[] { "myssoclient" };

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory().withClient("android-client")
//				.authorizedGrantTypes("client-credentials", "password", "refresh_token")
//				.authorities("ROLE_CLIENT", "ROLE_ANDROID_CLIENT").scopes("read", "write", "trust")
//				.resourceIds("oauth2-resource").accessTokenValiditySeconds(5000).secret("android-secret")
//				.refreshTokenValiditySeconds(50000);

		clients.inMemory().withClient("acme").secret("acmesecret")
				.authorizedGrantTypes("client-credentials", "authorization_code", "refresh_token", "password")
				.scopes(SCOPES_GRANTED).autoApprove(SCOPES_AUTO_APPROVED) ;

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET,
				HttpMethod.POST);
	}
	
	
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("x").password("x").roles("USER").and().withUser("manager")
//				.password("password").credentialsExpired(false).accountExpired(false).accountLocked(false)
//				.authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("MANAGER");
//	}
}