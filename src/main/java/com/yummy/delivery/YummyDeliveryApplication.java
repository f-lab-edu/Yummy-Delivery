package com.yummy.delivery;

import com.yummy.delivery.core.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class YummyDeliveryApplication {
  @Autowired UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(YummyDeliveryApplication.class, args);
  }
}
