package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = -320011733L;

    public static final QImage image = new QImage("image");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    public final NumberPath<Integer> imageType = createNumber("imageType", Integer.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QImage(String variable) {
        super(Image.class, forVariable(variable));
    }

    public QImage(Path<? extends Image> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImage(PathMetadata metadata) {
        super(Image.class, metadata);
    }

}

