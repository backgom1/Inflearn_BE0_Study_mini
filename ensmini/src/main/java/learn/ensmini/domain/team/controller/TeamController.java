package learn.ensmini.domain.team.controller;

import learn.ensmini.domain.team.dto.request.TeamCreateRequest;
import learn.ensmini.domain.team.dto.response.TeamCreateResponse;
import learn.ensmini.domain.team.dto.response.TeamListResponseDto;
import learn.ensmini.domain.team.exception.DuplicateTeamNameException;
import learn.ensmini.domain.team.exception.TeamNotFoundException;
import learn.ensmini.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 팀에 관련된 요청을 처리를 담당하는 컨트롤러 클래스
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-07
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class TeamController {

    private final TeamService teamService;

    /**
     * 팀 생성에 대한 요청 메서드
     * @param request 팀을 생성하기 위한 요청 객체 파라미터
     * @return 팀 생성 성공 메세지
     * @throws DuplicateTeamNameException 중복 검사 예외
     */
    @PostMapping("/team")
    @ResponseStatus(HttpStatus.OK)
    public TeamCreateResponse saveTeam(@RequestBody TeamCreateRequest request) throws DuplicateTeamNameException {
        teamService.save(request);
        return TeamCreateResponse.builder()
                .status(200)
                .msg("팀 생성을 성공했습니다.")
                .build();
    }

    /**
     * 팀 조회 기능 요청 메서드
     * @return 전체 팀 조회 반환
     */
    @GetMapping("/team")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamListResponseDto> findAllTeam() throws TeamNotFoundException {
        return teamService.findAllTeam();
    }
}
