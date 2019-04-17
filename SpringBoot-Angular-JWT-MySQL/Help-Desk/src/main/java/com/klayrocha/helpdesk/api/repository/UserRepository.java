package com.klayrocha.helpdesk.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klayrocha.helpdesk.api.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);

	Optional<User> findById(Long id);

	void deleteById(Long id);

}
