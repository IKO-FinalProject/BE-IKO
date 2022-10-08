package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFavor is a Querydsl query type for Favor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavor extends EntityPathBase<Favor> {

    private static final long serialVersionUID = -323119346L;

    public static final QFavor favor = new QFavor("favor");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> favorId = createNumber("favorId", Integer.class);

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QFavor(String variable) {
        super(Favor.class, forVariable(variable));
    }

    public QFavor(Path<? extends Favor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFavor(PathMetadata metadata) {
        super(Favor.class, metadata);
    }

}

