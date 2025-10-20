package com.entra.webapp.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Service
public class WebAppService {

  private final RestTemplate restTemplate = new RestTemplate();

  public String requestMiddleTierApi(String path, String accessToken) {

	log.info("Requesting Middle Tier API with token : {}", accessToken);
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(accessToken); // <-- attach token for middle-tier
    return restTemplate
        .exchange(
            URI.create(
                System.getenv()
                    .getOrDefault(
                        "MIDDLE_TIER_BASE_URL",
                        String.format("http://middle-tier-api:8080/%s", path))),
            HttpMethod.GET,
            new HttpEntity<>(headers),
            String.class)
        .getBody();
  }
}
