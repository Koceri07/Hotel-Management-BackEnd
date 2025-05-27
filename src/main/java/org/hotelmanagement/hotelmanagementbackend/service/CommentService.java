package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.model.dto.CommentDto;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.CommentMapper;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.ClientRepository;
import org.hotelmanagement.hotelmanagementbackend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ClientRepository clientRepository;

    public void createComment(CommentDto commentDto){
        log.info("Action.createComment.start for cilent id {}", commentDto.getClientId());
        var commentEntity = CommentMapper.INSTANCE.toEntity(commentDto);
        commentRepository.save(commentEntity);
        log.info("Action.createComment.end for client id {}", commentDto.getClientId());
    }

    public ApiResponse getAllComments(){
        log.info("Action.getAllComments.start");
        var comments = commentRepository.findAll()
                .stream()
                .map(CommentMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(comments);
        log.info("Action.getAllComments.end");
        return apiResponse;
    }

    public ApiResponse getCommentById(Long id){
        log.info("Action.getCommentById.start for id {}",id);
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var commentDto = CommentMapper.INSTANCE.toDto(comment);
        ApiResponse apiResponse = new ApiResponse(commentDto);
        log.info("Action.getCommentById.end for id {}",id);
        return apiResponse;
    }

    public void deleteCommentById(Long id){
        log.info("Acton.deleteCommentById.star for id {}",id);
        commentRepository.deleteById(id);
        log.info("Action.deleteCommentById.end for id {}", id);
    }

}
