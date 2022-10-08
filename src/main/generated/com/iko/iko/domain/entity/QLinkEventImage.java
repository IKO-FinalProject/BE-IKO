package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLinkEventImage is a Querydsl query type for LinkEventImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLinkEventImage extends EntityPathBase<LinkEventImage> {

    private static final long serialVersionUID = -614743125L;

    public static final QLinkEventImage linkEventImage = new QLinkEventImage("linkEventImage");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> eventId = createNumber("eventId", Integer.class);

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    public final NumberPath<Integer> linkId = createNumber("linkId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QLinkEventImage(String variable) {
        super(LinkEventImage.class, forVariable(variable));
    }

    public QLinkEventImage(Path<? extends LinkEventImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLinkEventImage(PathMetadata metadata) {
        super(LinkEventImage.class, metadata);
    }

}

