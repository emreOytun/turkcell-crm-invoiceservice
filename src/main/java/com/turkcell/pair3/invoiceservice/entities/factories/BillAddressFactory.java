package com.turkcell.pair3.invoiceservice.entities.factories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.entities.BillAddress;

public class BillAddressFactory {
    public static BillAddress create(Integer addressId, BillAccount billAccount) {
        BillAddress billAddress = new BillAddress();
        billAddress.setAddressId(addressId);
        billAddress.setBillAccount(billAccount);
        return billAddress;
    }
}
