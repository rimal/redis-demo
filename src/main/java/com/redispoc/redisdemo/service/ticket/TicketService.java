package com.redispoc.redisdemo.service.ticket;

import com.redispoc.redisdemo.core.model.Ticket;
import com.redispoc.redisdemo.repository.ticket.TicketRepository;
import com.redispoc.redisdemo.service.customer.CustomerDTO;
import com.redispoc.redisdemo.service.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/*
https://egkatzioura.com/2015/08/26/set-up-redis-cache-on-your-spring-project/
 */
@Service
public class TicketService {

  private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

  private final CustomerService customerService;
  private final TicketRepository ticketRepository;

  @Autowired
  private RedisTemplate<String, Object> template;

  @Resource(name = "redisTemplate")
  private ListOperations<String, Object> listOps;
  @Resource(name = "redisTemplate")
  private HashOperations<String, String, Object> hashOps;


  @Autowired
  public TicketService(
      CustomerService customerService,
      TicketRepository ticketRepository
  ) {
    this.customerService = customerService;
    this.ticketRepository = ticketRepository;
  }

  @Transactional(readOnly = true)
  @Cacheable(value = "tickets", key = "#id")
  public TicketDTO getTicket(Long id) throws Exception {
    logger.info("Getting ticket from db");
    Ticket ticket = ticketRepository.getOne(id);
    customerService.getCustomer(ticket.getCustomerId());

    /*if(true){
      throw new Exception("TEST");
    }*/

    return new TicketDTO(ticket);
  }

  @Transactional(readOnly = true)
  public TicketDTO getTicketTemplate(Long id) throws Exception {
    logger.info("Getting ticket from db");
    Ticket ticket = ticketRepository.getOne(id);
    CustomerDTO customerDTO = customerService.getCustomerTemplate(ticket.getCustomerId());

    listOps.leftPush("tickets::customer-" + ticket.getId(), customerDTO);
//    System.out.println(listOps.size("tickets::customer-" + ticket.getId()));

    hashOps.put("customers::open-tickets-" + ticket.getCustomerId(), ticket.getHash(), new TicketDTO(ticket));
    System.out.println(hashOps.size("customers::open-tickets-" + ticket.getCustomerId()));

    TicketDTO ticketDTO = new TicketDTO(ticket);
    ticketDTO.setHash(ticket.getHash() + "test");
    ticketDTO.setChannel("test channel1");
    hashOps.put("customers::open-tickets-" + ticket.getCustomerId(), ticketDTO.getHash(), ticketDTO);
    System.out.println(hashOps.size("customers::open-tickets-" + ticket.getCustomerId()));

    TicketDTO ticketDTO1 = new TicketDTO(ticket);
    ticketDTO1.setChannel("test channel2");
    hashOps.put("customers::open-tickets-" + ticket.getCustomerId(), ticketDTO1.getHash(), ticketDTO1);
    System.out.println(hashOps.size("customers::open-tickets-" + ticket.getCustomerId()));

    ticketDTO1 = new TicketDTO(ticket);
    ticketDTO1.setChannel("test channel3");
    hashOps.putIfAbsent("customers::open-tickets-" + ticket.getCustomerId(), ticketDTO1.getHash(), ticketDTO1);
    System.out.println(hashOps.size("customers::open-tickets-" + ticket.getCustomerId()));
    /*if(true){
      throw new Exception("TEST");
    }*/
    return new TicketDTO(ticket);
  }
}