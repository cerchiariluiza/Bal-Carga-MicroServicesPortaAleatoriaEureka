package com.luiza.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiza.hrpayroll.entitys.Payments;
import com.luiza.hrpayroll.services.PaymentService;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payments> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payments payment = service.getPayments(workerId, days);
		return ResponseEntity.ok(payment);
	}	
	
	public ResponseEntity<Payments> getPaymentAlternative(Long workerId, Integer days) {
		Payments payment = new Paymenst("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
