package com.spring.maxym.cryptodealbottask.mapper;

import com.spring.maxym.cryptodealbottask.dto.MarkPriceDto;
import com.spring.maxym.cryptodealbottask.entity.MarkPrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkPriceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    MarkPrice toEntity(MarkPriceDto dto);

    @InheritInverseConfiguration
    MarkPriceDto toDto(MarkPrice entity);

    List<MarkPrice> toEntities(List<MarkPriceDto> dtos);

    @InheritInverseConfiguration
    List<MarkPriceDto> toDtos(List<MarkPrice> entities);
}
