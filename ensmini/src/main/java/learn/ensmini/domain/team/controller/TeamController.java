package learn.ensmini.domain.team.controller;

import learn.ensmini.domain.team.dto.response.TeamListResponseDto;
import learn.ensmini.domain.team.exception.DuplicateTeamNameException;
import learn.ensmini.domain.team.dto.request.TeamCreateRequest;
import learn.ensmini.domain.team.dto.response.TeamCreateResponse;
import learn.ensmini.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team")
    @ResponseStatus(HttpStatus.OK)
    public TeamCreateResponse saveTeam(@RequestBody TeamCreateRequest request) throws DuplicateTeamNameException {
        teamService.save(request);
        return TeamCreateResponse.builder()
                .status(200)
                .msg("팀 생성을 성공했습니다.")
                .build();
    }

    @GetMapping("/team")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamListResponseDto> findAllTeam() {
        return teamService.findAllTeam();
    }
}
