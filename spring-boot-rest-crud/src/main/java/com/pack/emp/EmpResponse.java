package com.pack.emp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmpResponse {
	
private RestTemplate restTemplate;
	
	public EmpResponse() {
		restTemplate = new RestTemplate();
	}
	
	@Value("${endpoint}")
	String endpoint;
	
	public String getEmp() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class).getBody();
	}
}
