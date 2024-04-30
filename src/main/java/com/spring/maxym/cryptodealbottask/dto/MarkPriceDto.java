package com.spring.maxym.cryptodealbottask.dto;


import java.math.BigDecimal;

public record MarkPriceDto(
        String symbol,
        BigDecimal markPrice,
        BigDecimal indexPrice,
        BigDecimal estimatedSettlePrice,
        BigDecimal lastFundingRate,
        Long nextFundingTime,
        BigDecimal interestRate,
        Long time
) {
}
