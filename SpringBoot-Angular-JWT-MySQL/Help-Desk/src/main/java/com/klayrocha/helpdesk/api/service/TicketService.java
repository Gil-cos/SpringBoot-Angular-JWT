package com.klayrocha.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.klayrocha.helpdesk.api.enums.PriorityEnum;
import com.klayrocha.helpdesk.api.enums.StatusEnum;
import com.klayrocha.helpdesk.api.model.ChangeStatus;
import com.klayrocha.helpdesk.api.model.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);

	Optional<Ticket> findById(Long id);

	void delete(Long id);

	Page<Ticket> listTicket(int page, int count);

	ChangeStatus createChangeStatus(ChangeStatus changeStatus);

	Iterable<ChangeStatus> listChangeStatus(Long ticketId);

	Page<Ticket> findByCurrentUser(int page, int count, Long userId);

	Page<Ticket> findByParameters(int page, int count, String title, StatusEnum status, PriorityEnum priority);

	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, StatusEnum status, PriorityEnum priority,
			Long userId);

	Page<Ticket> findByNumber(int page, int count, Integer number);

	Iterable<Ticket> findAll();

	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, StatusEnum status,
			PriorityEnum priority, Long assignedUserId);
}
