package com.rj.orderservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RefreshScope
public class OrderController {

  private final String orderType;

  public OrderController(@Value("${order-type}") String orderType) {
    this.orderType = orderType;
  }

  @GetMapping("/type")
  public ResponseEntity<String> type(){
    return ResponseEntity.ok(orderType);
  }
}
