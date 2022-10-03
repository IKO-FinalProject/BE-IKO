package com.iko.iko.domain.repository.product;

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
    List<ProductResponse.GetAllProductDistinct> getAllProduct();

    Long getMemberIsFavorite(Integer memberId, Integer selectedProductId);
}
