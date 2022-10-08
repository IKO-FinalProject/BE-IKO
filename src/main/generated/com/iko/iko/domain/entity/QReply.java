package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = -311923782L;

    public static final QReply reply = new QReply("reply");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath imageUrl = createString("imageUrl");

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final NumberPath<Integer> orderId = createNumber("orderId", Integer.class);

    public final NumberPath<Integer> productDetailsId = createNumber("productDetailsId", Integer.class);

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final NumberPath<Integer> replyId = createNumber("replyId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QReply(String variable) {
        super(Reply.class, forVariable(variable));
    }

    public QReply(Path<? extends Reply> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReply(PathMetadata metadata) {
        super(Reply.class, metadata);
    }

}

