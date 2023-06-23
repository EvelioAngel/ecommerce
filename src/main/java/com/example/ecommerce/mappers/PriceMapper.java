package com.example.ecommerce.mappers;

import org.mapstruct.Mapper;

import com.example.ecommerce.dto.PriceDto;
import com.example.ecommerce.entities.Price;

@Mapper(componentModel = "spring", uses = {})
public interface PriceMapper {

	PriceDto mapToDto(Price entity);
}
