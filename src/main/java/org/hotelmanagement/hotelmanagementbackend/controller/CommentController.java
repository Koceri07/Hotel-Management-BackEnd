package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.CommentDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CommentDto commentDto){
        commentService.createComment(commentDto);
    }

    @GetMapping
    public ApiResponse getAll(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.deleteCommentById(id);
    }

}
