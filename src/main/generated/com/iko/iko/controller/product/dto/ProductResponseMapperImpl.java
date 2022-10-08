package com.iko.iko.controller.product.dto;

import com.iko.iko.domain.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-08T13:51:27+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
public class ProductResponseMapperImpl implements ProductResponseMapper {

    @Override
    public ProductResponse ofProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        return productResponse;
    }
}
