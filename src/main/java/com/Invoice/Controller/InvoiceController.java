package com.Invoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Models.Invoice;
import com.Invoice.Repository.InvoiceRepository;
import com.Invoice.Service.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
//@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@PostMapping
	public void createInvoice(@RequestBody Invoice invoice) {
		invoiceService.saveInvoice(invoice);
	}

	@GetMapping("/{userId}")
	public List<Invoice> getAllInvoices(@PathVariable Long userId) {
		return invoiceRepository.getByUserId(userId);
//		return invoiceService.getAllInvoices();
	}

//	@GetMapping("/{id}")
//	public Invoice getInvoiceById(@PathVariable Long id) {
//		return invoiceService.getInvoiceById(id);
//	}
//
//	@DeleteMapping("/{id}")
//	public String deleteInvoice(@PathVariable Long id) {
//		invoiceService.deleteInvoice(id);
//		return "Invoice with ID " + id + " deleted successfully.";
//	}
}
