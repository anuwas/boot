package com.pack.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pack.emp.EmpResponse;
import com.pack.emp.Employee;
import com.pack.emp.EmployeeList;
import com.pack.entity.Country;
import com.pack.restresponse.Response;

@RestController
@RequestMapping("/emp")
public class ConsumeController {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeController.class);
	
	@Autowired
	private EmpResponse empResponse;
	
	private RestTemplate restTemplate;
	
	public ConsumeController() {
		restTemplate = new RestTemplate();
	}
	
	@Value("${endpoint}")
	String endpoint;

	//@GetMapping("/all")
	@GetMapping(path= "/all")
	public String allCountry() {
		
		/*final EmployeeList responseBody = restTemplate.getForObject(
				endpoint, EmployeeList.class);*/
		
		/*final List<Employee> responseEntity = (List<Employee>) restTemplate.getForObject(
				endpoint, Employee.class);
				log.info(responseEntity.toString());
				System.out.println(responseEntity.toString());
				return "hello";*/
		/*HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class).getBody();*/
		return empResponse.getEmp();
	}
	
	@GetMapping(path= "/all")
	public Response responseObj() {
		Response response = restTemplate.getForObject(
                "http://services.groupkt.com/country/get/iso2code/IN",
                 Response.class);
		return response;
	}
	
}
