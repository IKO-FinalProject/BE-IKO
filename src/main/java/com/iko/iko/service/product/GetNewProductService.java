package com.iko.iko.service.product;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.domain.repository.member.MemberRepository;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNewProductService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public ProductDetailsResponse.MainFilterProductData getNewProduct(){
        Integer totalCount=0;

/*
        ProductDetailsResponse.MainFilterProductData result = new (
                totalCount,

                );

 */
        return null;
    }
}
