package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.StaffMapper;
import org.hotelmanagement.hotelmanagementbackend.model.dto.StaffDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;

    public void addStaff(StaffDto staffDto){
        log.info("Action.addStaff.start for id {}", staffDto.getId());
        var staffEntity = StaffMapper.INSTANCE.toEntity(staffDto);
        staffRepository.save(staffEntity);
        log.info("Action.addStaff.end for id {}", staffDto.getId());
    }

    public ApiResponse getStaffById(Long id){
        log.info("Action.getStaffById.start for id {}", id);
        var staff = staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("IdnOt Found"));
        var staffDto = StaffMapper.INSTANCE.toDto(staff);
        ApiResponse apiResponse = new ApiResponse(staffDto);
        log.info("Action.getStaffById.end for id {}",id);
        return apiResponse;
    }

    public ApiResponse getAllStaffs(){
        log.info("Action.getAllStaffs.start");
        var staffs = staffRepository.findAll()
                .stream()
                .map(StaffMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(staffs);
        log.info("Action.getAllStaffs.end");
        return apiResponse;
    }

    public void deleteStaffById(Long id){
        log.info("Action.deleteStaffById.start for id {}", id);
        staffRepository.deleteById(id);
        log.info("Action.deleteStaffById.end for id {}",id);
    }
}
