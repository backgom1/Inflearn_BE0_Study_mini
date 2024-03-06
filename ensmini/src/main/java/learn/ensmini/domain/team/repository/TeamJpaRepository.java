package learn.ensmini.domain.team.repository;

import learn.ensmini.domain.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamJpaRepository extends JpaRepository<Team, Long> {

    String findByName(String name);

    Optional<Team> findTeamByName(String teamName);
}
