package com.ekwateur.picsou.controller;


import com.ekwateur.picsou.model.invoice.Bill;
import com.ekwateur.picsou.services.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers/{customerRef}/bills")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public ResponseEntity<Bill> getInvoice(@PathVariable String customerRef, @RequestParam String month) {
        return ResponseEntity.ok(billingService.generateBill(month, customerRef));
    }
}
