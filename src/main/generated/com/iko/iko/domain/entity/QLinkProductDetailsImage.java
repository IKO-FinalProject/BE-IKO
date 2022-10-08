package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLinkProductDetailsImage is a Querydsl query type for LinkProductDetailsImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLinkProductDetailsImage extends EntityPathBase<LinkProductDetailsImage> {

    private static final long serialVersionUID = -294393538L;

    public static final QLinkProductDetailsImage linkProductDetailsImage = new QLinkProductDetailsImage("linkProductDetailsImage");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    public final NumberPath<Integer> linkId = createNumber("linkId", Integer.class);

    public final NumberPath<Integer> productDetailsId = createNumber("productDetailsId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QLinkProductDetailsImage(String variable) {
        super(LinkProductDetailsImage.class, forVariable(variable));
    }

    public QLinkProductDetailsImage(Path<? extends LinkProductDetailsImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLinkProductDetailsImage(PathMetadata metadata) {
        super(LinkProductDetailsImage.class, metadata);
    }

}

