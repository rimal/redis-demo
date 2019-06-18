package com.redispoc.redisdemo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the customer database table.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "master_customer_id")
  private Long masterCustomerId;

  @Column(name = "client_id")
  private Long clientId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date")
  private Date createDate;

  @NaturalId
  @Column(name = "customer_hash")
  private String hash;

  @Column(name = "channel_customer_id")
  private String channelCustomerId;

  @Column(name = "language")
  private String language;

  private String name;

  private String gender;

  private Date dob;

  /*@Column(name = "referral_code")
  private String referralCode;*/

  @Column(name = "crm_customer_id")
  private String crmCustomerId;

  @Column(name = "client_session_id")
  private String clientSessionId;

  @JsonIgnore
  @Column(name = "client_session_expiry")
  private Date clientSessionExpiry;

  @Column(name = "client_identifier")
  private String clientIdentifier;

  @Column(name = "logged_in", nullable = false)
  private boolean loggedIn;

  @Column(name = "extra_info")
  private String extraInfo;


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

  /*public String getCustomerHash() {
    return hash;
  }

  public void setCustomerHash(String customerHash) {
    this.hash = customerHash;
  }*/

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

  /*public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  public Boolean getSubscribed() {
    return subscribed;
  }

  public void setSubscribed(Boolean subscribed) {
    this.subscribed = subscribed;
  }*/

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

  /*public String getReferralCode() {
    return referralCode;
  }

  public void setReferralCode(String referralCode) {
    this.referralCode = referralCode;
  }*/

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

  public void setClientIdentifier(String customerIdentifier) {
    this.clientIdentifier = customerIdentifier;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Customer c = (Customer) o;

    return id.intValue() == c.getId().intValue();

  }

  @Override
  public int hashCode() {
    return id.intValue();
  }
}