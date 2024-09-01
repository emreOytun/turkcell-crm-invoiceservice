package com.turkcell.pair3.invoiceservice.services.concretes;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.entities.factories.BillAddressFactory;
import com.turkcell.pair3.invoiceservice.repositories.BillAddressRepository;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BillAddressServiceImpl implements BillAddressService {

    private final BillAddressRepository billAddressRepository;

    public void saveBillAddress(Integer addressId, BillAccount billAccount) {
        billAddressRepository.save(BillAddressFactory.create(addressId, billAccount));
    }
}
