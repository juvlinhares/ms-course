package com.devsuperior.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	// colocar numa variavel o valor do hr-worker.host
	@Value("${hr-worker.host}")
	private String workerHost;

	// injeção de RestTemplate:
	@Autowired
	private RestTemplate restTemplate;

	// create a payment:
	public Payment getPayment(Long workerId, Integer days) {
		// criar mapa de parametros:
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);
		
		//fazer a requisição restTemplate
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

		return new Payment(worker.getName(),worker.getDailyInCome(), days);

	}
}