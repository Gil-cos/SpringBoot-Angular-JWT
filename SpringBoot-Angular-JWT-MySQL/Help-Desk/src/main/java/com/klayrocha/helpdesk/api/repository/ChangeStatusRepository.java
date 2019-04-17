package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klayrocha.helpdesk.api.model.ChangeStatus;

public interface ChangeStatusRepository extends JpaRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(Long ticketId);
}
