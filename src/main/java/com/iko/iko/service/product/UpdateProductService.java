package com.iko.iko.service.product;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.admin.dto.AdminRequest;
import com.iko.iko.domain.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService {
    private final ProductRepository productRepository;

    public String updateProduct(AdminRequest.ProductUpdateRequest productUpdateRequest) {
        Long updateResult = productRepository.updateProduct(productUpdateRequest);
        if(updateResult > 0) {
            return "OK";
        } else {
            throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
        }
    }
}
