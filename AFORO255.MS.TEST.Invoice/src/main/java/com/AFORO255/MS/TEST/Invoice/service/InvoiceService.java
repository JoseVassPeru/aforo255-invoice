package com.AFORO255.MS.TEST.Invoice.service;

import com.AFORO255.MS.TEST.Invoice.model.entity.Invoice;
import com.AFORO255.MS.TEST.Invoice.model.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
