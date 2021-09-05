package com.luiza.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luiza.hrworker.entitys.Worker;

import com.luiza.hrworker.repositorys.WorkerRespository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRespository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>>findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
//		para validar se exceção gera rota alternativa
//		int x = 1;
//		if(x ==1)
				throw new RuntimeException("Test");
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
		
	}

}
