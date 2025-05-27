package org.hotelmanagement.hotelmanagementbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.entity.MarketItemEntity;
import org.hotelmanagement.hotelmanagementbackend.entity.MarketSaleEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.exception.StockEmptyException;
import org.hotelmanagement.hotelmanagementbackend.mapper.MarketSaleMapper;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketSaleDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.MarketSaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarketSaleService {
    private final MarketSaleRepository marketSaleRepository;

    @Transactional
    public void createSale(MarketSaleDto marketSaleDto){
        log.info("Action.createSale.start for id {}", marketSaleDto.getId());
        var sale = MarketSaleMapper.INSTANCE.toEntity(marketSaleDto);
        marketSaleDto.getItems().stream().forEach(item ->{
            if (item.getStock() > 0){
                item.setStock(item.getStock() - 1);
            }
            else {
                throw new StockEmptyException("Stock Is Empty");
            }
        });
        marketSaleRepository.save(sale);
        log.info("Action.createSale.end for id {}", marketSaleDto.getId());
    }

    public ApiResponse getSaleById(Long id){
        log.info("Action.getSaleById.start for id {}", id);
        var sale = marketSaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        ApiResponse apiResponse = new ApiResponse(sale);
        log.info("Action.getSaleById.end for id {}",id);
        return apiResponse;
    }

    public ApiResponse getAllSales(){
        log.info("Action.getAllSales.start");
        var sales = marketSaleRepository.findAll()
                .stream()
                .map(MarketSaleMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(sales);
        return apiResponse;
    }

    public void deleteSaleById(Long id){
        log.info("Action.deleteSaleById.start for id {}",id);
        marketSaleRepository.deleteById(id);
        log.info("Action.deleteSaleById.end for id {}",id);
    }

    public MarketSaleDto getMarketSaleDtoById(Long id){
        log.info("Action.getMarketSaleDtoById.start for id {}", id);
        var sale = marketSaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var saleDto = MarketSaleMapper.INSTANCE.toDto(sale);
        log.info("Action.getMarketSaleDtoById.end for id {}", id);
        return saleDto;
    }

    public Integer getRoomNumberById(Long id){
        log.info("Action.getRoomNumberById.start for id {}", id);
        var sale = marketSaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
        log.info("Action.getRoomNumberById.end for id {}",id);
        return sale.getRoomNumber();
    }

    public MarketSaleDto getSaleByRoomNumber(Integer roomNumber){
        log.info("Action.getSaleByRoomNumber.start for room number {}", roomNumber);
        Long id = marketSaleRepository.findIdByRoomNumber(roomNumber);
        return getMarketSaleDtoById(id);
    }


    public ApiResponse getTotalPrice(Integer roomNumber){
        log.info("Action.getTotalPrice.start for room number {}", roomNumber);
        MarketSaleDto marketSaleDto = getSaleByRoomNumber(roomNumber);
        var items = marketSaleDto.getItems();
        var total = items.stream()
                .mapToDouble(MarketItemDto::getItemPrice)
                .sum();
        ApiResponse apiResponse = new ApiResponse(total);
        log.info("Action.getTotalPrice.end for room number {}", roomNumber);
        return apiResponse;
    }
}
