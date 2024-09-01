package com.turkcell.pair3.invoiceservice.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillAddressMapper {
    BillAddressMapper INSTANCE = Mappers.getMapper(BillAddressMapper.class);

}
