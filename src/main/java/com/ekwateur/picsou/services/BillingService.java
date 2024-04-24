package com.ekwateur.picsou.services;

import com.ekwateur.picsou.model.invoice.Bill;

public interface BillingService {

    /**
     * Generate an Invoice for the given customer
     *
     * @param month       Ignored
     * @param customerRef the customerRef
     * @return An invoice with energy consumption, prices, sub-bill per energy and sum
     */
    Bill generateBill(String month, String customerRef);
}
