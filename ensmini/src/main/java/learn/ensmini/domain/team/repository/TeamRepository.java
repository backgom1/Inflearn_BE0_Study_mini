package learn.ensmini.domain.team.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import learn.ensmini.domain.team.dto.response.TeamListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static learn.ensmini.domain.team.domain.QTeam.team;

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

    /**
     * 팀 조회 쿼리
     * @return 전체 팀
     */
    public List<TeamListResponseDto> findAllTeam() {
        queryFactory = new JPAQueryFactory(em);
        return queryFactory.select(Projections.constructor(TeamListResponseDto.class,
                        team.name,
                        team.manager,
                        team.memberCount))
                .from(team)
                .fetch();
    }
}
