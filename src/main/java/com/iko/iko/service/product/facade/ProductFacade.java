package com.iko.iko.service.product.facade;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.admin.dto.AdminRequest;
import com.iko.iko.controller.admin.dto.AdminResponse;
import com.iko.iko.controller.product.dto.request.ProductRequest.ProductSaveRequest;
import com.iko.iko.service.product.*;
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
    private final GetAllProductByOptionService getAllProductByOptionService;
    private final FindProductIdAndNameService findProductIdAndNameService;
    private final UpdateProductDetailsService updateProductDetailsService;
    private final FindAllProductInfoService findAllProductInfoService;

    @Transactional(readOnly = true)
    public List<ProductDetailsResponse.MainProductForResponse>
    getMainProduct(Pageable pageable,Integer memberId){

        return getAllProductService.GetMainProduct(pageable,memberId);
    }

    @Transactional
    public String saveProductService(ProductSaveRequest productSaveRequest){
        return saveProductService.saveProduct(productSaveRequest);
    }

    @Transactional
    public List<ProductDetailsResponse.MainProductForResponse>
    getMainProductByOption(ProductDetailsRequest.ProductOptionForRequest productOption,
                           Pageable pageable, Integer memberId){
        return getAllProductByOptionService.GetMainProductByOption(productOption,pageable,memberId);
    }

    @Transactional(readOnly = true)
    public List<AdminResponse.ProductIdAndNameResponse> findProductIdAndName(Pageable pageable) {
        return findProductIdAndNameService.findProductIdAndName(pageable);
    }

    @Transactional
    public String updateProductDetails(AdminRequest.ProductDetailsUpdateRequest productDetailsUpdateRequest) {
        return updateProductDetailsService.updateProductDetails(productDetailsUpdateRequest);
    }

    @Transactional(readOnly = true)
    public List<AdminResponse.AllProductInfoResponse> findAllProductInfo(Pageable pageable) {
        return findAllProductInfoService.findAllProductInfo(pageable);
    }
}