package com.iko.iko.service.product;

import com.iko.iko.controller.admin.dto.AdminResponse;
import com.iko.iko.domain.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProductInfoService {
    private final ProductRepository productRepository;

    public List<AdminResponse.AllProductInfoResponse> findAllProductInfo(Pageable pageable) {
        return productRepository.findAllProductInfo(pageable);
    }
}
