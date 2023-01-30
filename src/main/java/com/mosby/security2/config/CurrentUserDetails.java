package com.mosby.security2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mosby.security2.entities.CurrentUser;
import com.mosby.security2.repositories.CurrentUserRepository;

@Service
public class CurrentUserDetails implements UserDetailsService  {

	@Autowired
	CurrentUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String userName, password = null;
		List<GrantedAuthority> authorities = null;
		List<CurrentUser> user = userRepository.findByEmail(username);
		if(user.size() == 0) {
			throw new UsernameNotFoundException("User details not found for "+username);
		}else {
			userName = user.get(0).getEmail();
			password = user.get(0).getPwd();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
		}
		return new User(userName,password,authorities);
	}

}
