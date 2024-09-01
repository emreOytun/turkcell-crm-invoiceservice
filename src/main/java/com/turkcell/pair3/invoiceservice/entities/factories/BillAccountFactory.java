package com.turkcell.pair3.invoiceservice.entities.factories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;

public class BillAccountFactory {
    public static BillAccount create(Integer customerId, String accountName) {
        BillAccount billAccount = new BillAccount();
        billAccount.setCustomerId(customerId);
        billAccount.setAccountName(accountName);
        return billAccount;
    }
}
