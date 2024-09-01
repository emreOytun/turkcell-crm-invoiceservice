package com.turkcell.pair3.invoiceservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessExceptionFactory;
import com.turkcell.pair3.core.messages.Messages;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.invoiceservice.clients.ProductServiceClient;
import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.entities.factories.BillAccountFactory;
import com.turkcell.pair3.invoiceservice.repositories.BillAccountRepository;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAddressService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;
import com.turkcell.pair3.invoiceservice.services.mapper.BillAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillAccountServiceImpl implements BillAccountService {
    private final BillAccountRepository billAccountRepository;
    private final ProductServiceClient productServiceClient;
    private final BillAddressService billAddressService;
    private final MessageService messageService;

    @Override
    public void createBillAccount(AddBillAccountRequest request) {
        BillAccount billAccount = BillAccountFactory.create(request.getCustomerId(), request.getAccountName());
        if (request.getAddressId() != null) {
            request.getAddressId().stream().forEach(addressId -> billAddressService.saveBillAddress(addressId, billAccount));
        }
        billAccountRepository.save(billAccount);
    }

    @Override
    public UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest) {
        return null;
    }

    @Override
    public void deleteBillAccount(Integer id) {
        checkIfNoProductExistsByBillAccountIdOrThrowException(id);
        billAccountRepository.deleteById(id);
    }

    @Override
    public BillAccount getBillAccountById(Integer billAccountId) {
        return billAccountRepository.findById(billAccountId).orElseThrow(
                () -> BusinessExceptionFactory.createWithMessage(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_NOT_FOUND)));
    }

    @Override
    public List<BillAccountResponse> getInvoices(Integer customerId) {
        return searchBillAccountsByCustomerIdOrThrowExceptionIfNotFoundAny(customerId).stream()
                .map(BillAccountMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getAllInvoiceIds(Integer customerId) {
        return searchBillAccountIdsByCustomerIdOrThrowExceptionIfNotFoundAny(customerId);
    }

    private void checkIfNoProductExistsByBillAccountIdOrThrowException(Integer accountId) {
        if (productServiceClient.hasAccountProduct(accountId)) {
            throw BusinessExceptionFactory.createWithMessage(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_HAS_PRODUCT));
        }
    }

    private List<BillAccount> searchBillAccountsByCustomerIdOrThrowExceptionIfNotFoundAny(Integer customerId) {
        return billAccountRepository.findByCustomerId(customerId).orElseThrow(
                () -> BusinessExceptionFactory.createWithMessage(messageService.getMessage(Messages.BusinessErrors.NO_BILL_ACCOUNT_FOUND_GIVEN_ID)));
    }

    private List<Integer> searchBillAccountIdsByCustomerIdOrThrowExceptionIfNotFoundAny(Integer customerId) {
        return billAccountRepository.findIdsByCustomerId(customerId).orElseThrow(
                () -> BusinessExceptionFactory.createWithMessage(messageService.getMessage(Messages.BusinessErrors.NO_BILL_ACCOUNT_FOUND_GIVEN_ID)));
    }
}
