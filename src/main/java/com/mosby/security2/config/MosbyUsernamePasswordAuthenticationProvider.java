package com.mosby.security2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mosby.security2.entities.CurrentUser;
import com.mosby.security2.repositories.CurrentUserRepository;


@Component
public class MosbyUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private CurrentUserRepository currentUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<CurrentUser> currentUser = currentUserRepository.findByEmail(username);
		if(currentUser.size() > 0) {
			if(passwordEncoder.matches(pwd, currentUser.get(0).getPwd())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(currentUser.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(username, pwd,authorities);
			}else {
				throw new BadCredentialsException("Invalid Password.");
			}
		}else {
			throw new BadCredentialsException("User Not Found.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
