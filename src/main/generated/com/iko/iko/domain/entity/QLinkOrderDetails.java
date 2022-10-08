package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLinkOrderDetails is a Querydsl query type for LinkOrderDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLinkOrderDetails extends EntityPathBase<LinkOrderDetails> {

    private static final long serialVersionUID = 1564914014L;

    public static final QLinkOrderDetails linkOrderDetails = new QLinkOrderDetails("linkOrderDetails");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> linkId = createNumber("linkId", Integer.class);

    public final NumberPath<Integer> orderId = createNumber("orderId", Integer.class);

    public final NumberPath<Integer> pcs = createNumber("pcs", Integer.class);

    public final NumberPath<Integer> productDetailsId = createNumber("productDetailsId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QLinkOrderDetails(String variable) {
        super(LinkOrderDetails.class, forVariable(variable));
    }

    public QLinkOrderDetails(Path<? extends LinkOrderDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLinkOrderDetails(PathMetadata metadata) {
        super(LinkOrderDetails.class, metadata);
    }

}

