package com.turkcell.pair3.invoiceservice.services.mapper;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillAccountMapper {
    BillAccountMapper INSTANCE = Mappers.getMapper(BillAccountMapper.class);

    BillAccountResponse toResponse(BillAccount billAccount);
}