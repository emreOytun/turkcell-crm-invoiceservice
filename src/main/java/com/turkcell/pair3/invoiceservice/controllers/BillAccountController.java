package com.turkcell.pair3.invoiceservice.controllers;

import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class BillAccountController {
    private final BillAccountService billAccountService;

    @PostMapping
    public void create(@RequestBody @Valid AddBillAccountRequest addBillAccountRequest) {
        billAccountService.createBillAccount(addBillAccountRequest);
    }

    @GetMapping("/{customerId}")
    public List<BillAccountResponse> getInvoices(@PathVariable @NotNull Integer customerId) {
        return billAccountService.getInvoices(customerId);
    }

    // update an invoice
    @PutMapping("/{invoiceId}")
    public void updateInvoice(@PathVariable @NotNull Integer invoiceId) {
    }

    @DeleteMapping("/{invoiceId}")
    public void deleteInvoice(@PathVariable @NotNull Integer invoiceId) {
        billAccountService.deleteBillAccount(invoiceId);
    }

    @GetMapping("/{customerId}/getAllInvoiceIds")
    public List<Integer> getAllInvoiceIds(@PathVariable @NotNull Integer customerId) {
        return billAccountService.getAllInvoiceIds(customerId);
    }

}
