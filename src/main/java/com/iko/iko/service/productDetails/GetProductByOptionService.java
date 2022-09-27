package com.iko.iko.service.productDetails;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GetProductByOptionService {

    private final ProductDetailsRepository productDetailsRepository;

    public List<ProductDetailsResponse.ProductMainByOption>
    GetProductByOption (ProductDetailsRequest.ProductOptionForRequest productByOption){
        List<ProductDetailsResponse.ProductMainByOption> productMainByOptionList = productDetailsRepository.getProductByOption(productByOption);
        //여기서 가공하고 넘김
        List<String> imageUrlList = new ArrayList<>();
        ProductDetailsResponse.ProductMainByOptionResponse result = new ProductDetailsResponse.ProductMainByOptionResponse(
                productMainByOptionList.get(0).getProductId(),
                productMainByOptionList.get(0).getSeries(),
                productMainByOptionList.get(0).getPrice(),
                productMainByOptionList.get(0).getDiscount(),
                productMainByOptionList.get(0).getGraphicDiameter(),
                productMainByOptionList.get(0).getColorCode(),
                imageUrlList
        );

        int idx=0;
        boolean checkFirstData=false;
        for(ProductDetailsResponse.ProductMainByOption productMainByOption : productMainByOptionList){
            if(checkFirstData) {
                if(
                        productMainByOption.getProductId() == result.getProductId()
                )
            }
        }
    }
}
