package learn.ensmini.domain.commute.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommuteCreateRequest {

    @NotNull(message = "직원 아이디 입력은 필수입니다.")
    private Long id;

    @NotNull(message = "출퇴근 날짜 입력은 필수입니다.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime targetDateTime;
}
