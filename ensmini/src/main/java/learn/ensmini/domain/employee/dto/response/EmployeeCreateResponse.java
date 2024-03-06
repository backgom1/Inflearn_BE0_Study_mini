package learn.ensmini.domain.employee.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeCreateResponse {

    private int status;
    private String msg;

    public EmployeeCreateResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
