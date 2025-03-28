package com.example.rentalSystem.domain.professor.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProfessor is a Querydsl query type for Professor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfessor extends EntityPathBase<Professor> {

    private static final long serialVersionUID = 128783459L;

    public static final QProfessor professor = new QProfessor("professor");

    public final com.example.rentalSystem.domain.common.QBaseTimeEntity _super = new com.example.rentalSystem.domain.common.QBaseTimeEntity(this);

    public final EnumPath<com.example.rentalSystem.domain.affiliation.type.AffiliationType> campusType = createEnum("campusType", com.example.rentalSystem.domain.affiliation.type.AffiliationType.class);

    public final EnumPath<com.example.rentalSystem.domain.affiliation.type.AffiliationType> college = createEnum("college", com.example.rentalSystem.domain.affiliation.type.AffiliationType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created_at = _super.created_at;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.rentalSystem.domain.affiliation.type.AffiliationType> major = createEnum("major", com.example.rentalSystem.domain.affiliation.type.AffiliationType.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated_at = _super.updated_at;

    public QProfessor(String variable) {
        super(Professor.class, forVariable(variable));
    }

    public QProfessor(Path<? extends Professor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfessor(PathMetadata metadata) {
        super(Professor.class, metadata);
    }

}

