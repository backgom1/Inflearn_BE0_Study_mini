package learn.ensmini.domain.employee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -348081141L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    public final ListPath<learn.ensmini.domain.annual.domain.Annual, learn.ensmini.domain.annual.domain.QAnnual> employeeAnnual = this.<learn.ensmini.domain.annual.domain.Annual, learn.ensmini.domain.annual.domain.QAnnual>createList("employeeAnnual", learn.ensmini.domain.annual.domain.Annual.class, learn.ensmini.domain.annual.domain.QAnnual.class, PathInits.DIRECT2);

    public final ListPath<learn.ensmini.domain.commute.domain.Commute, learn.ensmini.domain.commute.domain.QCommute> employeeCommute = this.<learn.ensmini.domain.commute.domain.Commute, learn.ensmini.domain.commute.domain.QCommute>createList("employeeCommute", learn.ensmini.domain.commute.domain.Commute.class, learn.ensmini.domain.commute.domain.QCommute.class, PathInits.DIRECT2);

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath role = createString("role");

    public final learn.ensmini.domain.team.domain.QTeam teamEmployee;

    public final DatePath<java.time.LocalDate> workStartDate = createDate("workStartDate", java.time.LocalDate.class);

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teamEmployee = inits.isInitialized("teamEmployee") ? new learn.ensmini.domain.team.domain.QTeam(forProperty("teamEmployee")) : null;
    }

}

