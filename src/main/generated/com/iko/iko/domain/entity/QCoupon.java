package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoupon is a Querydsl query type for Coupon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoupon extends EntityPathBase<Coupon> {

    private static final long serialVersionUID = -1499752106L;

    public static final QCoupon coupon = new QCoupon("coupon");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> couponId = createNumber("couponId", Integer.class);

    public final NumberPath<Integer> couponType = createNumber("couponType", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> discount = createNumber("discount", Integer.class);

    public final NumberPath<Float> discountRate = createNumber("discountRate", Float.class);

    public final NumberPath<Integer> expirationPeriod = createNumber("expirationPeriod", Integer.class);

    public final NumberPath<Integer> minPrice = createNumber("minPrice", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QCoupon(String variable) {
        super(Coupon.class, forVariable(variable));
    }

    public QCoupon(Path<? extends Coupon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoupon(PathMetadata metadata) {
        super(Coupon.class, metadata);
    }

}

