package com.redispoc.redisdemo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "client_id")
  private Long clientId;

  @Column(name = "ext_ticket_id")
  private String externalTicketId;

  @Column(name = "crm_ticket_id")
  private String crmTicketId;

  @Column(name = "crm_ticket_channel_id")
  private String crmTicketChannelId;

  private Boolean broadcast;

  private String channel;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date")
  private Date createDate;

  private String lat;

  private String address;
  private String city;
  private String state;
  private String pincode;

  private String lon;

  @Column(name = "ticket_status_id")
  private Long ticketStatusId;

  @Column(name = "prev_ticket_id")
  private Long prevTicketId;

  @Column(name = "item_category_id")
  private Long itemCategoryId;

  @NaturalId
  @Column(name = "ticket_hash")
  private String hash;

  @Column(name = "conversation_hash")
  private String conversationHash;

  @Column(name = "customer_id")
  private Long customerId;

  @Column(name = "assigned_user_id")
  private Long assignedUserId;

  @Column(name = "offline_log_id")
  private Long offlineLogId;

  @Column(name = "bot_version_id")
  private Long botVersionId;

  @Column(name = "node_group_id")
  private Long nodeGroupId;

  @Column(name = "extra_info")
  private String extraInfo;

  @Column(name = "landing_url")
  private String landingUrl;

  @Column(name = "traffic_tracking_id")
  private Long trafficTrackingId;


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

  public String getCrmTicketId() {
    return crmTicketId;
  }

  public void setCrmTicketId(String crmTicketId) {
    this.crmTicketId = crmTicketId;
  }

  public String getCrmTicketChannelId() {
    return crmTicketChannelId;
  }

  public void setCrmTicketChannelId(String crmTicketChannelId) {
    this.crmTicketChannelId = crmTicketChannelId;
  }

  public Boolean getBroadcast() {
    return broadcast;
  }

  public void setBroadcast(Boolean broadcast) {
    this.broadcast = broadcast;
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

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
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

  public Long getItemCategoryId() {
    return itemCategoryId;
  }

  public void setItemCategoryId(Long itemCategoryId) {
    this.itemCategoryId = itemCategoryId;
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

  public Long getAssignedUserId() {
    return assignedUserId;
  }

  public void setAssignedUserId(Long assignedUserId) {
    this.assignedUserId = assignedUserId;
  }

  public Long getOfflineLogId() {
    return offlineLogId;
  }

  public void setOfflineLogId(Long offlineLogId) {
    this.offlineLogId = offlineLogId;
  }

  public Long getBotVersionId() {
    return botVersionId;
  }

  public void setBotVersionId(Long botVersionId) {
    this.botVersionId = botVersionId;
  }

  public Long getNodeGroupId() {
    return nodeGroupId;
  }

  public void setNodeGroupId(Long nodeGroupId) {
    this.nodeGroupId = nodeGroupId;
  }

  public String getExtraInfo() {
    return extraInfo;
  }

  public void setExtraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
  }

  public String getLandingUrl() {
    return landingUrl;
  }

  public void setLandingUrl(String landingUrl) {
    this.landingUrl = landingUrl;
  }

  public Long getTrafficTrackingId() {
    return trafficTrackingId;
  }

  public void setTrafficTrackingId(Long trafficTrackingId) {
    this.trafficTrackingId = trafficTrackingId;
  }
}