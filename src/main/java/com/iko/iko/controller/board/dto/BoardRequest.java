package com.iko.iko.controller.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class BoardRequest {
    @Getter
    @AllArgsConstructor
    @Builder
    @Setter
    public static class AddBoardRequest{
        private Integer boardType;
        private String boardTitle;
        private String boardContent;
    }
}
