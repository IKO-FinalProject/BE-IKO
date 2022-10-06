package com.iko.iko.service.product;

import com.iko.iko.controller.admin.dto.AdminResponse;
import com.iko.iko.domain.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProductIdAndNameService {
    private final ProductRepository productRepository;

    public List<AdminResponse.ProductIdAndNameResponse> findProductIdAndName(Pageable pageable) {
        return productRepository.findProductIdAndName(pageable);
    }
}
