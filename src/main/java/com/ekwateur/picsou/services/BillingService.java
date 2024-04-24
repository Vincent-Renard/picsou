package com.ekwateur.picsou.services;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.invoice.Invoice;

public interface BillingService {

    /**
     * Generate an Invoice for the given customer
     *
     * @param month    Ignored
     * @param customer the customer
     * @return An invoice with energy consumption, prices, sub-bill per energy and sum
     */
    Invoice generateBill(String month, Customer customer);
}
