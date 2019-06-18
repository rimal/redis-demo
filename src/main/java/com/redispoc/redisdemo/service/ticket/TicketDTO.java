package com.redispoc.redisdemo.service.ticket;

import com.redispoc.redisdemo.core.model.Ticket;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

public class TicketDTO implements Serializable {

  private Long id;
  private Long clientId;
  private String hash;
  private String externalTicketId;
  private String channel;
  private Date createDate;
  private Long ticketStatusId;
  private Long prevTicketId;

  private String conversationHash;

  private Long customerId;

  public TicketDTO() {
  }

  public TicketDTO(Ticket ticket) {
    BeanUtils.copyProperties(ticket, this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public String getExternalTicketId() {
    return externalTicketId;
  }

  public void setExternalTicketId(String externalTicketId) {
    this.externalTicketId = externalTicketId;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Long getTicketStatusId() {
    return ticketStatusId;
  }

  public void setTicketStatusId(Long ticketStatusId) {
    this.ticketStatusId = ticketStatusId;
  }

  public Long getPrevTicketId() {
    return prevTicketId;
  }

  public void setPrevTicketId(Long prevTicketId) {
    this.prevTicketId = prevTicketId;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getConversationHash() {
    return conversationHash;
  }

  public void setConversationHash(String conversationHash) {
    this.conversationHash = conversationHash;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}