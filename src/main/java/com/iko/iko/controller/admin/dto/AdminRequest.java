package com.iko.iko.controller.admin.dto;

import lombok.*;

public class AdminRequest {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductDetailsUpdateRequest {
        private Integer productDetailsId;
        private Integer productDetailsStock;
        private Integer soldOut;
    }
}
