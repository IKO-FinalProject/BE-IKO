package com.iko.iko.controller.admin.dto;

import lombok.*;

public class AdminResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductIdAndNameResponse{
        private Integer productId;
        private String name;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AllProductInfoResponse{
        private Integer productId;
        private String productName;
        private Integer price;
        private Integer discount;
        private Float diameter;
        private String manufacturer;
    }
}