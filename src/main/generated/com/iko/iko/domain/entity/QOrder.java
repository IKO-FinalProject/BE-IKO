package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -314318818L;

    public static final QOrder order = new QOrder("order1");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> couponId = createNumber("couponId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath destination = createString("destination");

    public final StringPath detailDestination = createString("detailDestination");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final StringPath message = createString("message");

    public final NumberPath<Integer> method = createNumber("method", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> orderId = createNumber("orderId", Integer.class);

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Integer> postCode = createNumber("postCode", Integer.class);

    public final StringPath receiverName = createString("receiverName");

    public final StringPath receiverPhone = createString("receiverPhone");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> totalPrice = createNumber("totalPrice", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

