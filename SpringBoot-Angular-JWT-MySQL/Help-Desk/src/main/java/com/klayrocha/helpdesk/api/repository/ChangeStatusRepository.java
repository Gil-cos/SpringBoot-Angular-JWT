package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klayrocha.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends JpaRepository<ChangeStatus, Long> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(Long ticketId);
}
