package org.hotelmanagement.hotelmanagementbackend.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.StaffDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/staffs")
@RequiredArgsConstructor
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:9999")},
        tags = {@Tag(name = "Staffs", description = "Staff operations")
})
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public void create(StaffDto staffDto){
        staffService.addStaff(staffDto);
    }

    @GetMapping("{id}")
    public ApiResponse getById(@PathVariable Long id){
        return staffService.getStaffById(id);
    }

    @GetMapping
    public ApiResponse getAll(){
        return staffService.getAllStaffs();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        staffService.deleteStaffById(id);
    }
}
