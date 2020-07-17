package com.AFORO255.MS.TEST.Invoice.service;

import com.AFORO255.MS.TEST.Invoice.model.entity.Invoice;

import java.util.List;

public interface IInvoiceService {
    public List<Invoice> findAll();
    public Invoice findById(Integer id);
    public Invoice save(Invoice invoice);
}
