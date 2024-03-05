package learn.ensmini.domain.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import learn.ensmini.domain.team.domain.QTeam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static learn.ensmini.domain.team.domain.QTeam.*;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TeamRepository {
    JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager em;

    public Long countByName(String name) {
        queryFactory = new JPAQueryFactory(em);
        return queryFactory.select(team.name.count())
                .from(team)
                .where(team.name.eq(name))
                .fetchOne();
    }
}