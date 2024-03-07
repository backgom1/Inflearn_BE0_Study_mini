package learn.ensmini.global.handler;


import learn.ensmini.domain.team.exception.DuplicateTeamNameException;
import learn.ensmini.domain.team.exception.TeamNotFoundException;
import learn.ensmini.global.dto.response.TeamErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 예외처리를 담당하는 클래스
 */
@RestControllerAdvice
public class TeamExceptionHandler {


    /**
     * 중복 사용자에 대한 예외처리 핸들러
     * @param exception
     * @return
     */
    @ExceptionHandler(DuplicateTeamNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TeamErrorResponse teamErrorResponse(DuplicateTeamNameException exception) {
        return TeamErrorResponse.builder()
                .status(exception.getStatus())
                .errMsg(exception.getMsg()).build();
    }

    /**
     * 팀 조회가 되지않을 경우에 대한 예외 핸들러
     * @param exception
     * @return
     */
    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public TeamErrorResponse teamFindErrorResponse(TeamNotFoundException exception) {
        return TeamErrorResponse.builder()
                .status(exception.getStatus())
                .errMsg(exception.getErrMsg()).build();
    }
}
