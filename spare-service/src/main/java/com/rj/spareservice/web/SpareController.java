package com.rj.spareservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spares")
@RefreshScope
public class SpareController {

  @GetMapping("/")
  public ResponseEntity<String> type(){
    return ResponseEntity.ok("spares service is responding ...");
  }
}
