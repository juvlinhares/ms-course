package com.devsuperior.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	// injeção de dependencia do workerfeignClient:
	@Autowired
	private WorkerFeignClient workerfeignClient;

	// metodo que vai instanciar o pagamento:

	public Payment getPayment(Long workerId, Integer days) {

		// montagem do path do worker:
		Worker worker = workerfeignClient.findById(workerId).getBody();

		// instancia do pagamento com as propriedades do worker:
		return new Payment(worker.getName(), worker.getDailyInCome(), days);
	}

}