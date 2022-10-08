package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductDetails is a Querydsl query type for ProductDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductDetails extends EntityPathBase<ProductDetails> {

    private static final long serialVersionUID = -658787453L;

    public static final QProductDetails productDetails = new QProductDetails("productDetails");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Float> basecurve = createNumber("basecurve", Float.class);

    public final StringPath color = createString("color");

    public final StringPath colorCode = createString("colorCode");

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Float> degree = createNumber("degree", Float.class);

    public final NumberPath<Integer> detailsExposure = createNumber("detailsExposure", Integer.class);

    public final NumberPath<Integer> detailsPrice = createNumber("detailsPrice", Integer.class);

    public final NumberPath<Float> graphicDiameter = createNumber("graphicDiameter", Float.class);

    public final NumberPath<Integer> isSale = createNumber("isSale", Integer.class);

    public final StringPath material = createString("material");

    public final NumberPath<Integer> moisture = createNumber("moisture", Integer.class);

    public final NumberPath<Integer> period = createNumber("period", Integer.class);

    public final NumberPath<Integer> productDetailsId = createNumber("productDetailsId", Integer.class);

    public final NumberPath<Integer> productDetailsStock = createNumber("productDetailsStock", Integer.class);

    public final NumberPath<Integer> productIdFk = createNumber("productIdFk", Integer.class);

    public final NumberPath<Integer> soldOut = createNumber("soldOut", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QProductDetails(String variable) {
        super(ProductDetails.class, forVariable(variable));
    }

    public QProductDetails(Path<? extends ProductDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductDetails(PathMetadata metadata) {
        super(ProductDetails.class, metadata);
    }

}

