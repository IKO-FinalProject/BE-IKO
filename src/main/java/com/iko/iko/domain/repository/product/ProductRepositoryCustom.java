package com.iko.iko.domain.repository.product;

import com.iko.iko.controller.admin.dto.AdminRequest;
import com.iko.iko.controller.admin.dto.AdminResponse;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Query;
import com.iko.iko.domain.entity.Member;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface ProductRepositoryCustom{
    Page<ProductResponse.GetAllProductDistinct> getAllProduct(Pageable pageable);

    Long getMemberIsFavorite(Integer memberId, Integer selectedProductId);

    List<ProductResponse.GetAllProductDistinct> getAllProductByProductId(Integer productId);

    List<AdminResponse.ProductIdAndNameResponse> findProductIdAndName(Pageable pageable);

    Long updateProductDetails(AdminRequest.ProductDetailsUpdateRequest productDetailsUpdateRequest);

    List<AdminResponse.AllProductInfoResponse> findAllProductInfo(Pageable pageable);

}
