package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.api.dto.ReferenceDto;
import org.example.api.request.CommentRequest;
import org.example.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public record CommentController(CommentService commentService) {

    @PostMapping
    @Operation(summary = "${comment.create}", responses = @ApiResponse(responseCode = "201"))
    public ResponseEntity<ReferenceDto> assign(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok().body(ReferenceDto.of(commentService.comment(commentRequest).getId()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "${comment.delete}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> assign(@PathVariable UUID id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
