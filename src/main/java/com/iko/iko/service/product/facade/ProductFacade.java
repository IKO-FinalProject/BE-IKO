package com.iko.iko.service.product.facade;

import com.iko.iko.controller.product.dto.ProductRequest.ProductSaveRequest;
import com.iko.iko.service.productDetails.SaveProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final SaveProductService saveProductService;

    @Transactional
    public String saveProductService(ProductSaveRequest productSaveRequest) {
        return saveProductService.saveProductService(productSaveRequest);
    }
}