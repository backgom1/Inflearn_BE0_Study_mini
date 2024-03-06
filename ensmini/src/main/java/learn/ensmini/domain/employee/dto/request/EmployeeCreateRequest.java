package learn.ensmini.domain.employee.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeCreateRequest {

    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

}
