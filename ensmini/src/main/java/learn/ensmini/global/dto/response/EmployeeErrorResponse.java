package learn.ensmini.global.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeErrorResponse {

    private int status;
    private String errMsg;

    public EmployeeErrorResponse(int status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }
}
