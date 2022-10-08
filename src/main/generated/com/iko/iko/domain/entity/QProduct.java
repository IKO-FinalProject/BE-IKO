package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -515034689L;

    public static final QProduct product = new QProduct("product");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Float> diameter = createNumber("diameter", Float.class);

    public final NumberPath<Integer> discount = createNumber("discount", Integer.class);

    public final NumberPath<Integer> exposure = createNumber("exposure", Integer.class);

    public final StringPath feature = createString("feature");

    public final StringPath manufacturer = createString("manufacturer");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final NumberPath<Integer> recommend = createNumber("recommend", Integer.class);

    public final StringPath series = createString("series");

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

