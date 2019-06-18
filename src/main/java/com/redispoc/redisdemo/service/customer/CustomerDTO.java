package com.redispoc.redisdemo.service.customer;

import com.redispoc.redisdemo.core.model.Customer;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CustomerDTO {

  private Long id;
  private Long masterCustomerId;
  private Long clientId;
  private Date createDate;
  private String hash;
  private String channelCustomerId;
  private String language;

  private String name;

  private String gender;

  private Date dob;

  private String crmCustomerId;
  private String clientSessionId;
  private Date clientSessionExpiry;
  private String clientIdentifier;
  private boolean loggedIn;
  private String extraInfo;

  public CustomerDTO() {
  }

  public CustomerDTO(Customer customer) {
    BeanUtils.copyProperties(customer, this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMasterCustomerId() {
    return masterCustomerId;
  }

  public void setMasterCustomerId(Long masterCustomerId) {
    this.masterCustomerId = masterCustomerId;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getChannelCustomerId() {
    return channelCustomerId;
  }

  public void setChannelCustomerId(String channelCustomerId) {
    this.channelCustomerId = channelCustomerId;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getCrmCustomerId() {
    return crmCustomerId;
  }

  public void setCrmCustomerId(String crmCustomerId) {
    this.crmCustomerId = crmCustomerId;
  }

  public String getClientSessionId() {
    return clientSessionId;
  }

  public void setClientSessionId(String clientSessionId) {
    this.clientSessionId = clientSessionId;
  }

  public Date getClientSessionExpiry() {
    return clientSessionExpiry;
  }

  public void setClientSessionExpiry(Date clientSessionExpiry) {
    this.clientSessionExpiry = clientSessionExpiry;
  }

  public String getClientIdentifier() {
    return clientIdentifier;
  }

  public void setClientIdentifier(String clientIdentifier) {
    this.clientIdentifier = clientIdentifier;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public String getExtraInfo() {
    return extraInfo;
  }

  public void setExtraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
  }
}