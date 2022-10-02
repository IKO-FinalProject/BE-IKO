package com.iko.iko.domain.repository.product;

import com.iko.iko.controller.product.dto.InsertProductInfoDto;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.entity.QProduct;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.iko.iko.domain.entity.QProduct.product;
import static com.iko.iko.domain.entity.QProductDetails.productDetails;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
/*
    @Override
    public List<ProductResponse.ProductMainResponse> getMainProduct(
            Pageable pageable
    ){

//        return jpaQueryFactory
//        .select(Projections.constructor(ProductResponse.ProductMainResponse.class,
//                product.name, ExpressionUtils.as(
//                        JPAExpressions
//                                .select(image.image_url)
//                                .from(image)
//                                .where(image.image_id.eq(product.imageId)),
//                        "imageUrl")
//                ,product.series,product.feature,product.discount,product.price,
//                ExpressionUtils.as(
//                        JPAExpressions
//                                .select(productDetails.colorCode)
//                                .from(productDetails)
//                                .where(productDetails.productIdFk.eq(product.productId)),
//                        "colorCode"
//                )))
//                .from(product)
//                .orderBy(product.createdAt.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
  return null;

    }

    @Override
    public List<ProductResponse.AllProduct> getProduct(Pageable pageable){

        return jpaQueryFactory
                .select(Projections.constructor(ProductResponse.AllProduct.class,
                        product.name, product.series,product.price,product.discount,
                        product.diameter,product.feature))
                .from(product)
                .orderBy(product.price.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }*/

    @Override
    public Long insertProductInfo(InsertProductInfoDto requestDto, Product product) {
        return jpaQueryFactory
                .insert(QProduct.product)
                .set(QProduct.product.name, requestDto.getProductName())
                .set(QProduct.product.price, requestDto.getPrice())
                .set(QProduct.product.discount, requestDto.getDiscount())
                .set(QProduct.product.diameter, requestDto.getDiameter())
                .set(QProduct.product.manufacturer, requestDto.getManufacturer())
                .set(QProduct.product.series, requestDto.getSeries())
                .set(QProduct.product.feature, String.join(",",requestDto.getFeature()))
                .set(QProduct.product.recommend, (requestDto.getRecommend()) ? 1 : 0)
                .set(QProduct.product.exposure, (requestDto.getExposure()) ? 1 : 0)
                .execute();
    }
}
