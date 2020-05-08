package com.tracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tracker.dao.UserDao;
import com.tracker.model.Users;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	UserDao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;	
	@Autowired
	AuthenticationManager authManager;	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	
	public Users save(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}
	

	@Override
	public Users findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	@Override
	public Users findByPassword(String password) {
		return userDao.findByPassword(password);
	}


	@Override
	public UserDetails findLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = myUserDetailsService.loadUserByUsername(authentication.getName());
	        return user;
	    }
	
	@Override
	public void autoLogin(String username,String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		
		authManager.authenticate(usernamePassAuthToken);
		
		if (usernamePassAuthToken.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(usernamePassAuthToken);
			logger.debug(String.format("Auto login %s successfully!", username));
		}
	}



	@Override
	public Users get(Integer id) {
		return userDao.getOne(id);
	}
	
	}

