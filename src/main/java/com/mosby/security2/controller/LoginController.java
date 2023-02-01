package com.mosby.security2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosby.security2.entities.CurrentUser;
import com.mosby.security2.repositories.CurrentUserRepository;

@RestController
public class LoginController {

	@Autowired
	private CurrentUserRepository currentUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody CurrentUser currentUser ){
		CurrentUser savedCurrentUser =null;
		ResponseEntity<String> response = null;
		try {
			// Default hash rounds is ten.    
			String hashPassword = passwordEncoder.encode(currentUser.getPwd());
			currentUser.setPwd(hashPassword);
			savedCurrentUser = currentUserRepository.save(currentUser);
			if(savedCurrentUser.getId() > 0) {
				response = new ResponseEntity<String>("Success", HttpStatus.CREATED);
			}
		}catch(Exception ex) {
			response = new ResponseEntity<String>("An Error has occured",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping("/loginUser")
	public CurrentUser getUserDetailsAfterLogin(Authentication authentication) {
		List<CurrentUser> users = currentUserRepository.findByEmail(authentication.getName());
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
	}
}
