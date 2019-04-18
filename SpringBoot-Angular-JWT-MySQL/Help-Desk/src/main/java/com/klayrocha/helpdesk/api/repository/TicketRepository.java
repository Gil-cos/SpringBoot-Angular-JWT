package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klayrocha.helpdesk.api.enums.PriorityEnum;
import com.klayrocha.helpdesk.api.enums.StatusEnum;
import com.klayrocha.helpdesk.api.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, Long userId);

	@Query("FROM Ticket t where t.title = :title and t.status = :status and t.priority = :priority ORDER BY t.date")
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Pageable pages);

	@Query("FROM Ticket t where t.title = :title and t.status = :status and t.priority = :priority and t.user.id = :userId ORDER BY t.date")
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndUserIdOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Long userId, Pageable pages);

	@Query("FROM Ticket t where t.title = :title and t.status = :status and t.priority = :priority and t.assignedUser.id = :assignedUserId ORDER BY t.date")
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndAssignedUserIdOrderByDateDesc(
			String title, StatusEnum status, PriorityEnum priority, Long assignedUserId, Pageable pages);

	Page<Ticket> findByNumber(Integer number, Pageable pages);
}
