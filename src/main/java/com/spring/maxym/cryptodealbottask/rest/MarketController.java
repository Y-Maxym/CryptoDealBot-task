package com.spring.maxym.cryptodealbottask.rest;

import com.spring.maxym.cryptodealbottask.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/market")
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @GetMapping("/premiumIndex")
    public ResponseEntity<?> getPremiumIndex(@RequestParam(value = "symbol", required = false) String symbol,
                                             @RequestParam(value = "save", required = false) boolean save) {
        if (isNull(symbol)) {
            return ResponseEntity.ok(marketService.getPremiumIndexList(save));
        }
        return ResponseEntity.ok(marketService.getPremiumIndex(symbol, save));
    }
}
