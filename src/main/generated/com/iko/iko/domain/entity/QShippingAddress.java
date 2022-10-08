package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShippingAddress is a Querydsl query type for ShippingAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShippingAddress extends EntityPathBase<ShippingAddress> {

    private static final long serialVersionUID = 1054133046L;

    public static final QShippingAddress shippingAddress = new QShippingAddress("shippingAddress");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final StringPath shipAddress = createString("shipAddress");

    public final NumberPath<Integer> shippingAddressId = createNumber("shippingAddressId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QShippingAddress(String variable) {
        super(ShippingAddress.class, forVariable(variable));
    }

    public QShippingAddress(Path<? extends ShippingAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShippingAddress(PathMetadata metadata) {
        super(ShippingAddress.class, metadata);
    }

}

