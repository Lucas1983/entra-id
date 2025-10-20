package com.entra.middletierapi.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MiddleTierApiController {

  @GetMapping("/devops")
  //  @PreAuthorize("hasAuthority('APPROLE_DEVOPS_ROLE')")
  //  @PreAuthorize("hasRole('DEVOPS_ROLE')")
  public String devops(Authentication authentication) {
    log.info("MIDDLE-TIER-API : DEVOPS endpoint accessed : {}", authentication);
    //    return webAppService.requestMiddleTierApi("devops");
    return "MIDDLE-TIER-API : DEVOPS Endpoint Accessed!";
  }

  @GetMapping("/business")
  //  @PreAuthorize("hasAuthority('APPROLE_BUSINESS_ROLE')")
  //  @PreAuthorize("hasRole('BUSINESS_ROLE')")
  public String business(Authentication authentication) {
    log.info("MIDDLE-TIER-API : BUSINESS endpoint accessed : {}", authentication);
    //    return webAppService.requestMiddleTierApi("business");
    return "MIDDLE-TIER-API : BUSINESS Endpoint Accessed!";
  }
}
