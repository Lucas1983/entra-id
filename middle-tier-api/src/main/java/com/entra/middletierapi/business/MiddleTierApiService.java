package com.entra.middletierapi.business;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class MiddleTierApiService {

  @Autowired private final WebClient webClient;

  public String requestDownstreamApi(String path, OAuth2AuthorizedClient client) {

    log.info("Requesting Downstream API with token : {}", client.getAccessToken().getTokenValue());

    String body =
        webClient
            .get()
            .uri(String.format("http://downstream-api:8080/%s", path))
            .attributes(oauth2AuthorizedClient(client))
            .retrieve()
            .bodyToMono(String.class)
            .block();
    log.info("Response from {} : {}", path, body);
    return "Get response " + (null != body ? "successfully" : "failed");
  }
}
