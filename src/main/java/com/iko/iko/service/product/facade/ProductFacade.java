package com.iko.iko.service.product.facade;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.product.dto.request.ProductRequest.ProductSaveRequest;
import com.iko.iko.service.product.GetAllProductService;
import com.iko.iko.service.product.SaveProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final GetAllProductService getAllProductService;
    private final SaveProductService saveProductService;

    @Transactional(readOnly = true)
    public List<ProductDetailsResponse.MainProductForResponse>
    getMainProduct(Pageable pageable){

        return getAllProductService.GetMainProduct(pageable);
    }

    @Transactional
    public String saveProductService(ProductSaveRequest productSaveRequest){
        return saveProductService.saveProduct(productSaveRequest);
    }

}