package com.entra.webapp.web.controller;

import com.entra.webapp.business.WebAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebAppController {

  private final WebAppService service;

  @GetMapping("/")
  public String login() {
    log.info("WEB-APP : Login endpoint accessed");
    return "WEB-APP : Login Successful!";
  }

  @GetMapping("/devops")
  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.DEVOPS_ROLE')")
  public String devops(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api") OAuth2AuthorizedClient client) {
    log.info("WEB-APP : DEVOPS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("devops", client);
  }

  @GetMapping("/business")
  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.BUSINESS_ROLE')")
  public String business(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api") OAuth2AuthorizedClient client) {
    log.info("WEB-APP : BUSINESS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("business", client);
  }
}
