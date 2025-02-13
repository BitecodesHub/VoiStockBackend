package com.Invoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Models.DeliveryChallan;
import com.Invoice.Repository.DeliveryChallanRepository;

@RestController
@RequestMapping("/api/dchallan")
public class DeliveryChallanController {

	@Autowired
	private DeliveryChallanRepository deliveryChallanRepository;

	@GetMapping("/{userId}")
	public List<DeliveryChallan> getAllByUserId(@PathVariable Long userId) {
		System.out.println("HERE IS DATA : " + deliveryChallanRepository.getByUserId(userId));
		return deliveryChallanRepository.getByUserId(userId);
	}

	@PostMapping
	public DeliveryChallan createDeliveryChallan(@RequestBody DeliveryChallan deliveryChallan) {
		return deliveryChallanRepository.save(deliveryChallan);
	}

}
