package com.AFORO255.MS.TEST.Invoice.controller;

import com.AFORO255.MS.TEST.Invoice.model.entity.Invoice;
import com.AFORO255.MS.TEST.Invoice.service.IInvoiceService;
import com.AFORO255.MS.TEST.Invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping("/listar")
    public List<Invoice> listar(){
        return invoiceService.findAll();
    };

    @GetMapping("/ver/{id}")
    public Invoice detalle(@PathVariable Integer id){
        Invoice invoice = invoiceService.findById(id);
        return invoice;
    }

    @PostMapping("/save")
    public Invoice save(@RequestBody Invoice invoice){
        return invoiceService.save(invoice);
    }


}
