package learn.ensmini.domain.annual.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnual is a Querydsl query type for Annual
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnual extends EntityPathBase<Annual> {

    private static final long serialVersionUID = -1135981395L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnual annual = new QAnnual("annual");

    public final NumberPath<Long> annualId = createNumber("annualId", Long.class);

    public final learn.ensmini.domain.employee.domain.QEmployee employeeAnnual;

    public final DateTimePath<java.time.LocalDateTime> registDate = createDateTime("registDate", java.time.LocalDateTime.class);

    public final learn.ensmini.domain.team.domain.QTeam teamAnnual;

    public QAnnual(String variable) {
        this(Annual.class, forVariable(variable), INITS);
    }

    public QAnnual(Path<? extends Annual> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnual(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnual(PathMetadata metadata, PathInits inits) {
        this(Annual.class, metadata, inits);
    }

    public QAnnual(Class<? extends Annual> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employeeAnnual = inits.isInitialized("employeeAnnual") ? new learn.ensmini.domain.employee.domain.QEmployee(forProperty("employeeAnnual"), inits.get("employeeAnnual")) : null;
        this.teamAnnual = inits.isInitialized("teamAnnual") ? new learn.ensmini.domain.team.domain.QTeam(forProperty("teamAnnual")) : null;
    }

}

