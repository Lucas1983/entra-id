package com.entra.downstreamapi.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DownstreamApiController {

  @GetMapping("/devops")
  @PreAuthorize("hasAuthority('APPROLE_DOWNSTREAM_API.DEVOPS_ROLE')")
  public String devops(Authentication authentication) {
    log.info("DOWNSTREAM-API : DEVOPS endpoint accessed : {}", authentication);
    return "DOWNSTREAM-API : DEVOPS Endpoint Accessed!";
  }

  @GetMapping("/business")
  @PreAuthorize("hasAuthority('APPROLE_DOWNSTREAM_API.BUSINESS_ROLE')")
  public String business(Authentication authentication) {
    log.info("DOWNSTREAM-API : BUSINESS endpoint accessed : {}", authentication);
    return "DOWNSTREAM-API : BUSINESS Endpoint Accessed!";
  }
}
