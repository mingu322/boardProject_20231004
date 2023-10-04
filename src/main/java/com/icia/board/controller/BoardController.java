package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardPages/boardSave")
    public String boardSave(){
        return "boardPages/boardSave";
    }

    @PostMapping("/boardPages/boardSave")
    public String boardSave(@ModelAttribute BoardDTO boardDTO){
       Long savedId = boardService.save(boardDTO);
        System.out.println(savedId);
        return "index";
    }

    @GetMapping("/boardPages/boardList")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        System.out.println(id);
        boardService.increaseHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardDetail", boardDTO);
        return "boardPages/boardDetail";
    }
}
