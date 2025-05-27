package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.MinibarMapper;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MinibarItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.MinibarItemRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MinibarService {
    private final MinibarItemRepository minibarItemRepository;

    public void createMinibarItem(MinibarItemDto minibarItemDto){
        log.info("Action.createMinibarItem.start for id {}", minibarItemDto.getId());
        var item = MinibarMapper.INSTANCE.toEntity(minibarItemDto);
        minibarItemRepository.save(item);
        log.info("Action.createMinibarItem.end for id {}", minibarItemDto.getId());
    }

    public ApiResponse getMinibarItemById(Long id){
        log.info("Action.getMinibarItemById.start for id {}",id);
        var item = minibarItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id not Found"));
        var itemDto = MinibarMapper.INSTANCE.toDto(item);
        ApiResponse apiResponse = new ApiResponse(itemDto);
        return apiResponse;
    }

    public ApiResponse getAllMinibarItems(){
        log.info("Action.getAllMinibarItems.start");
        var items = minibarItemRepository.findAll().stream()
                .map(MinibarMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(items);
        log.info("Action.getAllMinibarItems.end");
        return apiResponse;
    }

    public void deleteMinibarItemById(Long id){
        log.info("Action.deleteMinibarItemById.start for id {}", id);
        minibarItemRepository.deleteById(id);
        log.info("Action.deleteMinibarItemById.end for id {}", id);
    }

}
