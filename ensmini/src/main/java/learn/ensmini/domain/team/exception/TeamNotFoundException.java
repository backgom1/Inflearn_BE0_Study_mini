package learn.ensmini.domain.team.exception;

import lombok.Getter;

@Getter
public class TeamNotFoundException extends Exception {
    private int status;
    private String errMsg;

    public TeamNotFoundException(int status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }
}
