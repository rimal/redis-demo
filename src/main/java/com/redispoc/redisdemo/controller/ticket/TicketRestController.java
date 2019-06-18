package com.redispoc.redisdemo.controller.ticket;

import com.redispoc.redisdemo.core.model.Customer;
import com.redispoc.redisdemo.service.customer.CustomerDTO;
import com.redispoc.redisdemo.service.customer.CustomerService;
import com.redispoc.redisdemo.service.ticket.TicketDTO;
import com.redispoc.redisdemo.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketRestController {

  private final TicketService ticketService;
  private final CustomerService customerService;

  @Autowired
  public TicketRestController(
      TicketService ticketService,
      CustomerService customerService
  ) {
    this.ticketService = ticketService;
    this.customerService = customerService;
  }

  @GetMapping(value = "/{ticketId}")
  public TicketDTO getTicket(@PathVariable Long ticketId) throws Exception {
    TicketDTO ticket = ticketService.getTicket(ticketId);
    CustomerDTO customer = customerService.getCustomer(ticket.getCustomerId());
    return ticket;
  }

  @GetMapping(value = "/template/{ticketId}")
  public TicketDTO getTicketTemplate(@PathVariable Long ticketId) throws Exception {
    TicketDTO ticket = ticketService.getTicketTemplate(ticketId);
    CustomerDTO customer = customerService.getCustomer(ticket.getCustomerId());
    return ticket;
  }
}