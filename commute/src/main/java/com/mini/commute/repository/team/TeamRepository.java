package com.mini.commute.repository.team;

import com.mini.commute.entity.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String teamName);

    @Query("select t from Team t left join fetch t.employees")
    List<Team> findAllJPQLFetch();
}
