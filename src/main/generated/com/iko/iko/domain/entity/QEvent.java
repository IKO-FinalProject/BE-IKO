package com.iko.iko.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = -323433622L;

    public static final QEvent event = new QEvent("event");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.sql.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath eventDescription = createString("eventDescription");

    public final DateTimePath<java.util.Date> eventEndTime = createDateTime("eventEndTime", java.util.Date.class);

    public final NumberPath<Integer> eventId = createNumber("eventId", Integer.class);

    public final DateTimePath<java.util.Date> eventStartTime = createDateTime("eventStartTime", java.util.Date.class);

    public final StringPath eventTitle = createString("eventTitle");

    //inherited
    public final DatePath<java.sql.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

