package com.iko.iko.controller.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertProductInfoDto {

    private String productName;

    private Integer price;

    private Integer discount;

    private Float diameter;

    private String manufacturer;

    private String series;

    private String[] feature;

    private Boolean recommend;

    private Boolean exposure;
}
