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

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductUpdateRequest {
        private Integer productId;
        private String productName;
        private Integer price;
        private Integer discount;
        private Float diameter;
        private String manufacturer;
    }
}
