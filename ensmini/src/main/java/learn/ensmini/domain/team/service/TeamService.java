package learn.ensmini.domain.team.service;

import learn.ensmini.domain.team.dto.response.TeamListResponseDto;
import learn.ensmini.domain.team.exception.DuplicateTeamNameException;
import learn.ensmini.domain.team.domain.Team;
import learn.ensmini.domain.team.dto.request.TeamCreateRequest;
import learn.ensmini.domain.team.repository.TeamJpaRepository;
import learn.ensmini.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 팀 관리에 대한 서비스 클래스
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-05
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamJpaRepository jpaRepository;
    private final TeamRepository repository;

    /**
     * 팀 생성에 대한 메서드 입니다.
     *
     * @param request 팀 생성 요청 파라미터
     */

    @Transactional
    public void save(TeamCreateRequest request) throws DuplicateTeamNameException {

        teamValidation(request);

        Team team = Team.builder()
                .name(request.getName())
                .manager(request.getManager())
                .memberCount(0)
                .annualRole(1).build();
        jpaRepository.save(team);
    }

    private void teamValidation(TeamCreateRequest request) throws DuplicateTeamNameException {
        if (repository.countByName(request.getName()) > 0) {
            throw new DuplicateTeamNameException(1000, "중복된 사용자 입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<TeamListResponseDto> findAllTeam() {
        return repository.findAllTeam();
    }
}
