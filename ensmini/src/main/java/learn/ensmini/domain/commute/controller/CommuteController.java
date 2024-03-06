package learn.ensmini.domain.commute.controller;

import learn.ensmini.domain.commute.dto.request.CommuteCalculateMinuteRequest;
import learn.ensmini.domain.commute.dto.request.CommuteCreateRequest;
import learn.ensmini.domain.commute.dto.response.CommuteCreateResponse;
import learn.ensmini.domain.commute.dto.response.CommuteMinuteListDto;
import learn.ensmini.domain.commute.service.CommuteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 출/퇴근 관리를 위한 클래스
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-06
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class CommuteController {

    private final CommuteService commuteService;

    /**
     * 출퇴근 저장을 위한 컨트롤러
     *
     * @param request 출퇴근 직원
     * @return 200 OK!
     */
    @PostMapping("/commute")
    @ResponseStatus(HttpStatus.OK)
    public CommuteCreateResponse commuteEmployee(@RequestBody CommuteCreateRequest request) {
        return commuteService.commuteEmployee(request);
    }

    @GetMapping("/commute")
    @ResponseStatus(HttpStatus.OK)
    public CommuteMinuteListDto calculateWorkingTime(@RequestBody CommuteCalculateMinuteRequest request) {
        return commuteService.calculateWorkingTime(request);
    }
}
