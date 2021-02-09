package com.grofers.luckydraw;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Log4j2
@SpringBootApplication
public class LuckydrawApplication {

  public static void main(String[] args) {
    SpringApplication.run(LuckydrawApplication.class, args);
    log.info("Congrats! Your LuckydrawApplication server has started");
  }

  /**
   * Fetches a ModelMapper instance.
   *
   * @return ModelMapper
   */
  @Bean // Want a new obj every time
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
