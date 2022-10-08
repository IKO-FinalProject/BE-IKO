package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardImage is a Querydsl query type for BoardImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardImage extends EntityPathBase<BoardImage> {

    private static final long serialVersionUID = -1791831227L;

    public static final QBoardImage boardImage = new QBoardImage("boardImage");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> boardId = createNumber("boardId", Integer.class);

    public final NumberPath<Integer> boardImageId = createNumber("boardImageId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QBoardImage(String variable) {
        super(BoardImage.class, forVariable(variable));
    }

    public QBoardImage(Path<? extends BoardImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardImage(PathMetadata metadata) {
        super(BoardImage.class, metadata);
    }

}

