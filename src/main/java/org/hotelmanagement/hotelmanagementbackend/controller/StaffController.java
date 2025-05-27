package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.StaffDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/staffs")
@RequiredArgsConstructor
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
