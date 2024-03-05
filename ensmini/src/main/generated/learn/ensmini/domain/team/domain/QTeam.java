package learn.ensmini.domain.team.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = 1171035369L;

    public static final QTeam team = new QTeam("team");

    public final NumberPath<Integer> annualRole = createNumber("annualRole", Integer.class);

    public final ListPath<learn.ensmini.domain.annual.domain.Annual, learn.ensmini.domain.annual.domain.QAnnual> employeeAnnual = this.<learn.ensmini.domain.annual.domain.Annual, learn.ensmini.domain.annual.domain.QAnnual>createList("employeeAnnual", learn.ensmini.domain.annual.domain.Annual.class, learn.ensmini.domain.annual.domain.QAnnual.class, PathInits.DIRECT2);

    public final ListPath<learn.ensmini.domain.employee.domain.Employee, learn.ensmini.domain.employee.domain.QEmployee> employeeTeam = this.<learn.ensmini.domain.employee.domain.Employee, learn.ensmini.domain.employee.domain.QEmployee>createList("employeeTeam", learn.ensmini.domain.employee.domain.Employee.class, learn.ensmini.domain.employee.domain.QEmployee.class, PathInits.DIRECT2);

    public final StringPath manager = createString("manager");

    public final NumberPath<Integer> memberCount = createNumber("memberCount", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> teamId = createNumber("teamId", Long.class);

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

