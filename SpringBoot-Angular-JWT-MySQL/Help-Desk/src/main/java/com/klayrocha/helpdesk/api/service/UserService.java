package com.klayrocha.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.klayrocha.helpdesk.api.model.User;

@Component
public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	Optional<User> findById(Long id);
	
	void delete(Long id);
	
	Page<User> findAll(int page, int count);
}
