package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klayrocha.helpdesk.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
