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

  @GetMapping("/obo/devops")
  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.DEVOPS_ROLE')")
  public String devopsObo(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api-obo") OAuth2AuthorizedClient client) {
    log.info("WEB-APP OBO : DEVOPS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("obo/devops", client);
  }

  @GetMapping("/obo/business")
  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.BUSINESS_ROLE')")
  public String businessObo(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api-obo") OAuth2AuthorizedClient client) {
    log.info("WEB-APP OBO : BUSINESS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("obo/business", client);
  }

  @GetMapping("/cc/devops")
//  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.DEVOPS_ROLE')")
  public String devopsCc(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api-cc") OAuth2AuthorizedClient client) {
    log.info("WEB-APP CC : DEVOPS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("cc/devops", client);
  }

  @GetMapping("/cc/business")
//  @PreAuthorize("hasAuthority('APPROLE_WEB_APP.BUSINESS_ROLE')")
  public String businessCc(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("middle-tier-api-cc") OAuth2AuthorizedClient client) {
    log.info("WEB-APP CC : BUSINESS endpoint accessed : {}", authentication);
    return service.requestMiddleTierApi("cc/business", client);
  }
}
