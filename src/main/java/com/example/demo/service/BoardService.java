package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.dto.boardRequestDto;
import com.example.demo.repository.BoardRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;
    public void boardCreate(Board board){
        boardRepository.save(board);
    }
    public void boardDelete(Long boardId){
        boardRepository.deleteById(boardId);
    }

    public Board boardUpdate(Long id, boardRequestDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
        board.update(boardDto.getTitle(), boardDto.getContent());
        try {
            boardRepository.save(board);
        } catch (Exception e) {
            System.out.println("저장 실패");
        }
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다."));
    }
    public boardRequestDto getBoard(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
        boardRequestDto boardDto = new boardRequestDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setContent(board.getContent());
        return boardDto;
    }

}
