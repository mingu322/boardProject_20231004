package com.icia.board.dto;

import com.icia.board.entity.BoardEntity;
import com.icia.board.util.UtilClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private String createdAt;
    private int boardHits;

    public static BoardDTO toSaveDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardPassword(boardEntity.getBoardPassword());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setCreatedAt(UtilClass.dateTimeFormat(boardEntity.getCreatedAt()));

//        LocalDateTime createdAt = boardEntity.getCreatedAt();
//        String result = UtilClass.dateTimeFormat(createdAt);
//        boardDTO.setCreatedAt(result);

        return boardDTO;
    }
}