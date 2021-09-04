package com.luiza.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiza.hrpayroll.entitys.Payments;



@Service
public class PaymentService {
	


	public Payments getPayment(long workerId, int days) {
				
		Worker worker = findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
