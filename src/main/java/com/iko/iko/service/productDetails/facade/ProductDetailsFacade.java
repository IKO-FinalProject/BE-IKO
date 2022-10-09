package com.iko.iko.service.productDetails.facade;


import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;
import com.iko.iko.service.productDetails.*;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductDetailsFacade {
    private final GetMainProductDetailsService getMainProductDetailsService;
    private final GetMainProductService getMainProductService;
    private final GetProductForRandomService getProductForRandomService;
    private final GetProductByOptionService getProductByOptionService;
    private final GetProductExplainImageService getProductExplainImageService;
    private final GetByPeriodOption getByPeriodOption;



    @Transactional(readOnly = true)
    public List<String> getProductExplainImage(Integer productId){
        return getProductExplainImageService.getProductExplainImage(productId);
    }

    @Transactional(readOnly = true)
    public List<ProductDetailsResponse.ProductMainByOptionResponse>getProductByOption(
            ProductDetailsRequest.ProductOptionForRequest productByOption){
        return getProductByOptionService.GetProductByOption(productByOption);
    }



    @Transactional(readOnly = true)
    public ProductDetailsResponse.ProductDetailsForResponse
    getProductDetails(Integer selectedProductId, Integer memberId){
        return getMainProductDetailsService.GetProductDetails(selectedProductId,memberId);
    }

    @Transactional(readOnly = true)
    public List<ProductDetailsResponse.MainProductForResponse> getProductForRandom(
            Integer selectedProductId, Integer memberId
    ){
        return getProductForRandomService.getProductForRandom(selectedProductId,memberId);
    }

    @Transactional(readOnly = true)
    public ProductDetailsResponse.ByPeriodOptionList getByPeriodOption(Integer period){
        return getByPeriodOption.getByPeriodOption(period);
    }

}
