package com.iko.iko.service.product;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.admin.dto.AdminRequest;
import com.iko.iko.domain.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductDetailsService {
    private final ProductRepository productRepository;

    public String updateProductDetails(AdminRequest.ProductDetailsUpdateRequest productDetailsUpdateRequest) {
        Long updateResult = productRepository.updateProductDetails(productDetailsUpdateRequest);
        if(updateResult > 0) {
            return "OK";
        } else {
            throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
        }
    }
}
