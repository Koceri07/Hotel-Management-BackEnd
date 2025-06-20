package org.hotelmanagement.hotelmanagementbackend.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.MarketItemService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/market-items")
@RequiredArgsConstructor
@OpenAPIDefinition(tags = {
        @Tag(name = "Market Item", description = "Market Items operations")
})
public class MarketItemController {
    private final MarketItemService marketItemService;

    @PostMapping
    public void create(@RequestBody MarketItemDto marketItemDto){
        marketItemService.createItem(marketItemDto);
    }

    @GetMapping
    public ApiResponse getAll(){
        return marketItemService.getAllItems();
    }

    @GetMapping("{id}")
    public ApiResponse getById(@PathVariable Long id){
        return marketItemService.getItemById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        marketItemService.deleteItemById(id);
    }




}
