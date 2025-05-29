package org.hotelmanagement.hotelmanagementbackend.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MinibarItemDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.MinibarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/minibar")
@RequiredArgsConstructor
@OpenAPIDefinition(tags = {
        @Tag(name = "Minibar", description = "Minibar operations")
})
public class MInibarItemController {
    private final MinibarService minibarService;

    @PostMapping
    public void create(@RequestBody MinibarItemDto minibarItemDto){
        minibarService.createMinibarItem(minibarItemDto);
    }

    @GetMapping("{id}")
    public ApiResponse getById(@PathVariable Long id){
        return minibarService.getMinibarItemById(id);
    }

    @GetMapping
    public ApiResponse getAll(){
        return minibarService.getAllMinibarItems();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        minibarService.deleteMinibarItemById(id);
    }


}
