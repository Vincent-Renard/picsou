package com.ekwateur.picsou.services;

import com.ekwateur.picsou.model.invoice.Invoice;

public interface BillingService {

    /**
     * Generate an Invoice for the given customer
     *
     * @param month       Ignored
     * @param customerRef the customerRef
     * @return An invoice with energy consumption, prices, sub-bill per energy and sum
     */
    Invoice generateBill(String month, String customerRef);
}
