package learn.ensmini.global.handler;

import learn.ensmini.global.dto.ValidMsg;
import learn.ensmini.global.dto.response.CommonErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {


    /**
     * NotNull 처리를 위한 예외 처리 메서드
     *
     * @param e 요청받은 예외 사항
     * @return 에러 메세지 반환
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public CommonErrorResponse methodNotAllowedErrorHandler(MethodArgumentNotValidException e) {
        log.info("===== 입력값 NULL 예외 처리 발생 !!  -> 발생 Method() : {}() =====", Objects.requireNonNull(e.getFieldError()).getObjectName());
        List<ValidMsg> msgs = e.getFieldErrors().stream()
                .map(msg -> ValidMsg.builder()
                        .msg(msg.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        return CommonErrorResponse.builder()
                .status(e.getStatusCode().value())
                .validation(msgs)
                .build();
    }
}
