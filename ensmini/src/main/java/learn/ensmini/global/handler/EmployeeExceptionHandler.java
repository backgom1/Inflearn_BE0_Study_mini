package learn.ensmini.global.handler;

import learn.ensmini.domain.employee.exception.EmployeeException;
import learn.ensmini.global.dto.response.EmployeeErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 직원에 관련된 예외처리를 하는 핸들러
 */
@RestControllerAdvice
@Slf4j
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EmployeeErrorResponse employeeErrorResponse(EmployeeException e) {
        log.info("=================== EmployeeException =========================");
        return EmployeeErrorResponse.builder()
                .status(e.getStatus())
                .errMsg(e.getErrMsg())
                .build();
    }
}
