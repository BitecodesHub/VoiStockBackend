package com.Invoice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Invoice.Models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	Invoice getByInvoiceNo(String invoiceNo);

	List<Invoice> getByUserId(Long userId);
}
