package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.dto.boardRequestDto;
import com.example.demo.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    @PostMapping("/create/list")
    @Operation(summary = "게시글 등록",
            description = "게시글 등록")
    public ResponseEntity<?> createBoard(boardRequestDto boardRequestDto){
        Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .build();
        boardService.boardCreate(board);
        return new ResponseEntity<>("success",null);
    }
    @DeleteMapping("/delete/list")
    @Operation(summary = "게시글 삭제",
            description = "게시글 삭제")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id){
        boardService.boardDelete(id);
        return new ResponseEntity<>("success",null);
    }
    @PostMapping("/update/list")
    @Operation(summary = "게시글 수정",
            description = "게시글 수정")
    public Board update(@PathVariable Long id, boardRequestDto boardDto){
        return boardService.boardUpdate(id,boardDto);
    }
    @PostMapping("/get/list")
    @Operation(summary = "게시글 조회",
            description = "게시글 조회")
    public boardRequestDto getBoard(@PathVariable Long id){
        boardRequestDto board = boardService.getBoard(id);
        return board;
    }



}
