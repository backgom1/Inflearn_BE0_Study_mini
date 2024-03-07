package learn.ensmini.domain.employee.exception;

import lombok.Getter;

@Getter
public class EmployeeException extends Exception {
    private final int status;
    private final String errMsg;
    public EmployeeException(int status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }
}
