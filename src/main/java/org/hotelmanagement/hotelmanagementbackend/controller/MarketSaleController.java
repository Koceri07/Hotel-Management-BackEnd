package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketSaleDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.MarketItemService;
import org.hotelmanagement.hotelmanagementbackend.service.MarketSaleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/market-sales")
@RequiredArgsConstructor
public class MarketSaleController {
    private final MarketSaleService marketSaleService;

    @PostMapping
    public void create(@RequestBody MarketSaleDto marketSaleDto){
        marketSaleService.createSale(marketSaleDto);
    }

    @GetMapping
    public ApiResponse getAll(){
        return marketSaleService.getAllSales();
    }

    @GetMapping("{id}")
    public ApiResponse getById(@PathVariable Long id){
        return marketSaleService.getSaleById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        marketSaleService.deleteSaleById(id);
    }

    @GetMapping("{roomNumber}")
    public ApiResponse getTotalPrice(@PathVariable Integer roomNumber){
        return marketSaleService.getTotalPrice(roomNumber);
    }
}
