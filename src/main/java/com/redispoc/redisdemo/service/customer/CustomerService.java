package com.redispoc.redisdemo.service.customer;

import com.redispoc.redisdemo.repository.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerService {

  private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

  private final CustomerRepository customerRepository;
  @Autowired
  private RedisTemplate<String, Object> template;

  @Value("#{@environment.getProperty('custom.redis-cache.enable')}")
//  @Value("#{systemEnvironment['custom.redis-cache.enable']}")
//  @Value("${custom.redis-cache.enable}")
  public void setEnableRedis(Boolean enableRedis) {
    System.out.println("ENABLE REDIS------------" + enableRedis);
  }

  // inject the template as ListOperations
  @Resource(name = "redisTemplate")
  private ValueOperations<String, Object> valueOps;

  @Autowired
  public CustomerService(
      CustomerRepository customerRepository
  ) {
    this.customerRepository = customerRepository;
  }

  @Transactional(readOnly = true)
  @Cacheable(value = "customers", key = "#id")
  public CustomerDTO getCustomer(Long id) {
    logger.info("Getting customer from db");
    return new CustomerDTO(customerRepository.getOne(id));
  }

  @Transactional(readOnly = true)
  public CustomerDTO getCustomerTemplate(Long id) {
    logger.info("Getting customer from db");
    CustomerDTO customerDTO = new CustomerDTO(customerRepository.getOne(id));
    valueOps.set("customers::" + id, customerDTO);
    return customerDTO;
  }
}