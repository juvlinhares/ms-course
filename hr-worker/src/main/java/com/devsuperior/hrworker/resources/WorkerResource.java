package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	// logger:
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String testConfig;

	// injenção de dependencia do Enviroment

	@Autowired
	private Environment env;

	// endipoint que retorna todos os os workers do banco de dados

	@Autowired
	private WorkerRepository repository;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();

	}

	// findAll
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);

	}

	// find By Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("PORT =" + env.getProperty("local.server.port"));
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
