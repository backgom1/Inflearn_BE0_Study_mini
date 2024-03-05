package learn.ensmini.domain.commute.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommute is a Querydsl query type for Commute
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommute extends EntityPathBase<Commute> {

    private static final long serialVersionUID = -1935882121L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommute commute = new QCommute("commute");

    public final NumberPath<Long> commuteId = createNumber("commuteId", Long.class);

    public final learn.ensmini.domain.employee.domain.QEmployee employeeCommute;

    public final DateTimePath<java.time.LocalDateTime> registDate = createDateTime("registDate", java.time.LocalDateTime.class);

    public final EnumPath<learn.ensmini.domain.commute.enums.CommuteStatus> status = createEnum("status", learn.ensmini.domain.commute.enums.CommuteStatus.class);

    public QCommute(String variable) {
        this(Commute.class, forVariable(variable), INITS);
    }

    public QCommute(Path<? extends Commute> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommute(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommute(PathMetadata metadata, PathInits inits) {
        this(Commute.class, metadata, inits);
    }

    public QCommute(Class<? extends Commute> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employeeCommute = inits.isInitialized("employeeCommute") ? new learn.ensmini.domain.employee.domain.QEmployee(forProperty("employeeCommute"), inits.get("employeeCommute")) : null;
    }

}

