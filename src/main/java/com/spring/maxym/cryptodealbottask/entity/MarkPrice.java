package com.spring.maxym.cryptodealbottask.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mark_price", schema = "public")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MarkPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark_price_id_seq")
    @SequenceGenerator(name = "mark_price_id_seq", sequenceName = "mark_price_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "mark_price")
    private BigDecimal markPrice;

    @Column(name = "index_price")
    private BigDecimal indexPrice;

    @Column(name = "estimated_settle_price")
    private BigDecimal estimatedSettlePrice;

    @Column(name = "last_funding_rate")
    private BigDecimal lastFundingRate;

    @Column(name = "next_funding_time")
    private Long nextFundingTime;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "time")
    private Long time;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
