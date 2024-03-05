package learn.ensmini.global.handler;


import learn.ensmini.domain.team.exception.DuplicateTeamNameException;
import learn.ensmini.global.dto.response.TeamErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
