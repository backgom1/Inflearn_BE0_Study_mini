package learn.ensmini.domain.team.exception;

import lombok.Getter;

@Getter
public class DuplicateTeamNameException extends RuntimeException {

    private final int status;
    private final String msg;

    public DuplicateTeamNameException(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
