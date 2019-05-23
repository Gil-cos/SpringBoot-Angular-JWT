package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.klayrocha.helpdesk.api.entity.Ticket;
import com.klayrocha.helpdesk.api.enums.PriorityEnum;
import com.klayrocha.helpdesk.api.enums.StatusEnum;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, Long userId);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Pageable pages);

	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Long userId, Pageable pages);

	Page<Ticket> findByNumber(Integer number, Pageable pages);

	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Long assignedUserId, Pageable pages);
}
