package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.MarketItemMapper;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.MarketItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarketItemService {
    private final MarketItemRepository marketItemRepository;

    public void createItem(MarketItemDto marketItemDto) {
        log.info("Action.createItem.start for id {}", marketItemDto.getId());
        var item = MarketItemMapper.INSTANCE.toEntity(marketItemDto);
        marketItemRepository.save(item);
        log.info("Action.createItem.end for id {}", marketItemDto.getId());
    }

    public ApiResponse getItemById(Long id) {
        log.info("Action.getItemById.start for id {}", id);
        var item = marketItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        ApiResponse apiResponse = new ApiResponse(item);
        return apiResponse;
    }

    public ApiResponse getAllItems() {
        log.info("Action.getAllItems.start");
        var items = marketItemRepository.findAll()
                .stream()
                .map(MarketItemMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(items);
        return apiResponse;
    }

    public void deleteItemById(Long id){
        log.info("Action.deleteItemById.start for id {}",id);
        marketItemRepository.deleteById(id);
        log.info("Action.deleteItemById.end for id {}", id);
    }

    public void addStockById(Integer stock, Long id){
        log.info("Action.addStockById.start for id {}",id);
        var item = getMarketItemDtoById(id);
        item.setStock(item.getStock() + stock);
        log.info("Action.addStockById.end for id {}",id);
    }

    public MarketItemDto getMarketItemDtoById(Long id){
        log.info("Action.getMarketItemDtoById.start by id");
        var item = marketItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var itemDto = MarketItemMapper.INSTANCE.toDto(item);
        log.info("Action.getMarketItemDtoById.end for id {}", id);
        return itemDto;
    }
}
