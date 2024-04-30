package com.spring.maxym.cryptodealbottask.service;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.maxym.cryptodealbottask.dto.MarkPriceDto;
import com.spring.maxym.cryptodealbottask.entity.MarkPrice;
import com.spring.maxym.cryptodealbottask.mapper.MarkPriceMapper;
import com.spring.maxym.cryptodealbottask.repository.MarkPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarkPriceRepository priceRepository;
    private final MarkPriceMapper markPriceMapper;
    private final UMFuturesClientImpl client;
    private final ObjectMapper mapper;

    @SneakyThrows
    public MarkPriceDto getPremiumIndex(String symbol, boolean save) {
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        String info = client.market().markPrice(parameters);

        if (save) return save(mapper.readValue(info, MarkPriceDto.class));
        return mapper.readValue(info, MarkPriceDto.class);
    }

    @SneakyThrows
    public List<MarkPriceDto> getPremiumIndexList(boolean save) {
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "");
        String info = client.market().markPrice(parameters);

        if (save) return saveList(mapper.readValue(info, new TypeReference<>() {}));
        return mapper.readValue(info, new TypeReference<>() {});
    }

    @Transactional
    public MarkPriceDto save(MarkPriceDto markPrice) {
        MarkPrice entity = markPriceMapper.toEntity(markPrice);
        priceRepository.save(entity);
        return markPriceMapper.toDto(entity);
    }

    @Transactional
    public List<MarkPriceDto> saveList(List<MarkPriceDto> markPriceDtos) {
        List<MarkPrice> markPrices = markPriceMapper.toEntities(markPriceDtos);
        priceRepository.saveAll(markPrices);
        return markPriceMapper.toDtos(markPrices);
    }
}
