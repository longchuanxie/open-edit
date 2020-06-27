package com.xielc1.group.open.edit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xielc1.group.*","com.xielc1.group.*"})
public class OpenEditAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpenEditAppApplication.class, args);
  }

}
