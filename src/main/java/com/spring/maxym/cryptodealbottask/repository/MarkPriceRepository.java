package com.spring.maxym.cryptodealbottask.repository;

import com.spring.maxym.cryptodealbottask.entity.MarkPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkPriceRepository extends JpaRepository<MarkPrice, Long> {
}
