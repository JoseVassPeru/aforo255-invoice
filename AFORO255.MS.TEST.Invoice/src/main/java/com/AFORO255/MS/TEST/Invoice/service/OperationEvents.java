package com.AFORO255.MS.TEST.Invoice.service;

import com.AFORO255.MS.TEST.Invoice.model.entity.Invoice;
import com.AFORO255.MS.TEST.Invoice.model.entity.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationEvents {
    //para transformar el consumer record que nos va a llegar desde kafka

    @Autowired
    private IInvoiceService invoiceService;

    //para transformar a la entidad en json
    @Autowired
    ObjectMapper objectMapper;

    private Logger log = LoggerFactory.getLogger(OperationEvents.class);

    public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

        double nuevoMonto = 0;
        Invoice invoice = new Invoice();

        Operation operationEvent = objectMapper.readValue(consumerRecord.value(), Operation.class);
        invoice = invoiceService.findById(operationEvent.getIdInvoice());

        if(invoice.getState() == 1 && invoice.getAmount()>=operationEvent.getAmount() && invoice.getAmount()>=1){
            nuevoMonto = invoice.getAmount() - operationEvent.getAmount();
            invoice.setAmount(nuevoMonto);
            if(nuevoMonto == 0) invoice.setState(0);
            invoiceService.save(invoice);
        }
    }
}














