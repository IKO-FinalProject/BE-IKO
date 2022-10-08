package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLinkMemberCoupon is a Querydsl query type for LinkMemberCoupon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLinkMemberCoupon extends EntityPathBase<LinkMemberCoupon> {

    private static final long serialVersionUID = -1732553302L;

    public static final QLinkMemberCoupon linkMemberCoupon = new QLinkMemberCoupon("linkMemberCoupon");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> couponId = createNumber("couponId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DateTimePath<java.util.Date> expiredDate = createDateTime("expiredDate", java.util.Date.class);

    public final NumberPath<Integer> memberCouponId = createNumber("memberCouponId", Integer.class);

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QLinkMemberCoupon(String variable) {
        super(LinkMemberCoupon.class, forVariable(variable));
    }

    public QLinkMemberCoupon(Path<? extends LinkMemberCoupon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLinkMemberCoupon(PathMetadata metadata) {
        super(LinkMemberCoupon.class, metadata);
    }

}

