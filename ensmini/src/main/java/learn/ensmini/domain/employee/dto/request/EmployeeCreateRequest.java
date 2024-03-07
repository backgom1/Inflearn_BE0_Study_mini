package learn.ensmini.domain.employee.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeCreateRequest {

    @NotNull(message = "이름 입력은 필수입니다.")
    private String name;

    private String teamName;

    @NotNull(message = "직책 선택은 필수입니다.")
    private String role;


    @NotNull(message = "생일 입력은 필수 입니다.")
    private LocalDate birthday;

    @NotNull(message = "입사 일 입력 필수입니다.")
    private LocalDate workStartDate;

}
