package com.entra.middletierapi.web.controller;

import com.entra.middletierapi.business.MiddleTierApiService;
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
public class MiddleTierApiController {

  private final MiddleTierApiService service;

  @GetMapping("/devops")
  @PreAuthorize("hasAuthority('APPROLE_MIDDLE_TIER_API.DEVOPS_ROLE')")
  public String devops(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("downstream-api") OAuth2AuthorizedClient client) {
    log.info("MIDDLE-TIER-API : DEVOPS endpoint accessed : {}", authentication);
    return service.requestDownstreamApi("devops", client);
  }

  @GetMapping("/business")
  @PreAuthorize("hasAuthority('APPROLE_MIDDLE_TIER_API.BUSINESS_ROLE')")
  public String business(
      Authentication authentication,
      @RegisteredOAuth2AuthorizedClient("downstream-api") OAuth2AuthorizedClient client) {
    log.info("MIDDLE-TIER-API : BUSINESS endpoint accessed : {}", authentication);
    return service.requestDownstreamApi("business", client);
  }
}
