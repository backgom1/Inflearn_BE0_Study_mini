package learn.ensmini.domain.team.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamCreateResponse {

    private int status;
    private String msg;

    public TeamCreateResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
