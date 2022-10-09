package com.iko.iko.domain.repository.productDetails;


import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun.jdi.FloatValue;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.iko.iko.domain.entity.QLinkProductDetailsImage.linkProductDetailsImage;
import static com.iko.iko.domain.entity.QProduct.product;
import static com.iko.iko.domain.entity.QProductDetails.productDetails;
import static com.iko.iko.domain.entity.QImage.image;


@Repository
@RequiredArgsConstructor
public class ProductDetailsRepositoryImpl implements ProductDetailsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<ProductDetailsResponse.ProductDetailsFilterList> getDetailsFilterInfo(){
        return jpaQueryFactory
                .select(Projections.constructor(
                        ProductDetailsResponse.ProductDetailsFilterList.class,
                        productDetails.period,
                        productDetails.graphicDiameter,
                        productDetails.colorCode
                ))
                .from(productDetails)
                .distinct()
                .where(productDetails.degree.eq(Float.valueOf(0)))
                .fetch();
    }
    @Override
    public List<ProductDetailsResponse.GetColorCodeAndImageUrl> getColorAndImage(Integer selectedProductId){
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.GetColorCodeAndImageUrl.class,
                        productDetails.colorCode,
                        image.imageUrl
                ))
                .from(productDetails)
                .join(linkProductDetailsImage).on(productDetails.productDetailsId.eq(linkProductDetailsImage.productDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(productDetails.productIdFk.eq(selectedProductId))
                .where(image.imageType.eq(1))
                .where(productDetails.period.eq(30))
                .distinct()
                .fetch();
    }
    @Override
    public List<ProductDetailsResponse.GetGraphicDiameter> getGraphic(Integer selectedProductId){
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.GetGraphicDiameter.class,
                        productDetails.graphicDiameter))
                .from(productDetails)
                .where(productDetails.productIdFk.eq(selectedProductId))
                .orderBy(productDetails.graphicDiameter.asc())
                .distinct()
                .fetch();

    }
    @Override
    public List<ProductDetailsResponse.MainProduct> getMainProduct(Pageable pageable, Integer productId) {

        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.MainProduct.class,
                        productDetails.productDetailsId
                ))
                .from(productDetails)
                .join(product).on(productDetails.productIdFk.eq(product.productId)).fetchJoin()
                .where(productDetails.productIdFk.eq(productId))
                .distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

    }

    @Override
    public List<ProductDetailsResponse.ProductMainByOption> getProductByOption(
            ProductDetailsRequest.ProductOptionForRequest productByOption) {
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.ProductMainByOption.class,
                        product.productId,
                        product.series,
                        product.price,
                        product.discount,
                        productDetails.graphicDiameter,
                        productDetails.colorCode,
                        image.imageUrl))
                .from(productDetails)
                .join(product).on(productDetails.productIdFk.eq(product.productId)).fetchJoin()
                .join(linkProductDetailsImage).on(productDetails.productDetailsId.eq(linkProductDetailsImage.productDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(product.productId.eq(productDetails.productDetailsId))
                .where(convertStringWhere(productByOption.getColorCode(),"Color")
                        .or(convertFloatWhere(productByOption.getGraphicDiameter()))
                                .or(convertIntegerWhere(productByOption.getPeriod()))
                                .or(convertStringWhere(productByOption.getSeries(),"Series"))
                                .or(convertStringWhere(productByOption.getFeature(),"Feature")))
                        .distinct()
                        .fetch();

    }
    private BooleanBuilder convertIntegerWhere(List<Integer> integerList){
        BooleanBuilder builder = new BooleanBuilder();
        for(Integer tmp: integerList){
            builder.or(productDetails.period.eq(tmp));
        }
        return builder;
    }
    private BooleanBuilder convertStringWhere(List<String> stringList,String columnType){
        BooleanBuilder builder = new BooleanBuilder();
        for(String tmp: stringList){
            builder.or(columnType.equals("Color")?productDetails.colorCode.eq(tmp):(columnType.equals("Series")?product.series.eq(tmp):product.feature.eq(tmp)));
        }
        return builder;
    }
    private BooleanBuilder convertFloatWhere(List<Float> floatList){
        BooleanBuilder builder = new BooleanBuilder();
        for(Float tmp: floatList){
            builder.or(productDetails.graphicDiameter.eq(tmp));
        }
        return builder;
    }

    @Override
    public List<ProductDetailsResponse.ProductDetails> getProductDetails(Integer selectedProductId){
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.ProductDetails.class,
                        productDetails.colorCode,
                        productDetails.degree,
                        productDetails.graphicDiameter,
                        productDetails.period))
                .from(productDetails)
                .distinct()
                .where(productDetails.productIdFk.eq(selectedProductId))
                .fetch();
    }

    @Override
    public List<ProductDetailsResponse.typeAndImage> getTypeAndImageForProductDetailsId(Integer selectedProductDetailsId){
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.typeAndImage.class,
                        image.imageType,
                        image.imageUrl))
                .from(productDetails)
                .join(linkProductDetailsImage).on(linkProductDetailsImage.productDetailsId.eq(selectedProductDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(productDetails.productDetailsId.eq(selectedProductDetailsId))
                /*
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(productDetails.productIdFk.eq(selectedProductId))
                .where(image.imageType.eq(1))
                .where(productDetails.period.eq(30))
                */
                .distinct()
                .fetch();
    }
    @Override
    public List<ProductDetailsResponse.ListInfoForProductDetails> getListInfoForDetails(Integer selectedProductDetailsId){
        return jpaQueryFactory
                .select(Projections.constructor(ProductDetailsResponse.ListInfoForProductDetails.class,
                        productDetails.period,
                        productDetails.colorCode,
                        productDetails.graphicDiameter,
                        productDetails.degree))
                .from(productDetails)
                .where(productDetails.productDetailsId.eq(selectedProductDetailsId))
                .distinct()
                .fetch();

    }

    @Override
    public List<Integer> getProductByProductOption (ProductDetailsRequest.ProductOptionForRequest productByOption) {
        return jpaQueryFactory
                .select(productDetails.productIdFk)
                .from(productDetails)
                .join(product).on(productDetails.productIdFk.eq(product.productId)).fetchJoin()
                .join(linkProductDetailsImage).on(productDetails.productDetailsId.eq(linkProductDetailsImage.productDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(product.productId.eq(productDetails.productDetailsId))
                .where(convertStringWhere(productByOption.getColorCode(), "Color")
                        .or(convertFloatWhere(productByOption.getGraphicDiameter()))
                        .or(convertIntegerWhere(productByOption.getPeriod()))
                        .or(convertStringWhere(productByOption.getSeries(), "Series"))
                        .or(convertStringWhere(productByOption.getFeature(), "Feature")))
                .distinct()
                .fetch();
    }

    @Override
    public List<ProductDetailsResponse.typeAndImage> getTypeAndImageByProductId(Integer selectedProductId){
        return jpaQueryFactory
                .select(Projections.constructor(
                        ProductDetailsResponse.typeAndImage.class,
                        image.imageType,
                        image.imageUrl
                ))
                .from(productDetails)
                .join(linkProductDetailsImage).on(linkProductDetailsImage.productDetailsId.eq(productDetails.productDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(productDetails.productIdFk.eq(selectedProductId))
                .distinct()
                .fetch();
    }

    @Override
    public List<String> getExplainImageByProductId(Integer productId){
        return jpaQueryFactory
                .select(image.imageUrl)
                .from(productDetails)
                .join(linkProductDetailsImage).on(linkProductDetailsImage.productDetailsId.eq(productDetails.productDetailsId)).fetchJoin()
                .join(image).on(image.imageId.eq(linkProductDetailsImage.imageId)).fetchJoin()
                .where(image.imageType.eq(3))
                .where(productDetails.productIdFk.eq(productId))
                .distinct()
                .fetch();
    }

    @Override
    public List<ProductDetailsResponse.ByPeriodOption> getPeriodOption(Integer period){
        return jpaQueryFactory
                .select(Projections.constructor(
                        ProductDetailsResponse.ByPeriodOption.class,
                        productDetails.colorCode,
                        productDetails.graphicDiameter
                ))
                .from(productDetails)
                .where(productDetails.period.eq(period))
                .distinct()
                .fetch();
    }

}
