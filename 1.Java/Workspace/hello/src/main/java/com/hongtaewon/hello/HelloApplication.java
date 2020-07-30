package com.hongtaewon.hello;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class HelloApplication {
  @RequestMapping("/api/hello")
  public String hello() {
    return "안녕하세요. 현재 서버 시간은"+new Date()+ "입니다.\n";
  }
  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }
}