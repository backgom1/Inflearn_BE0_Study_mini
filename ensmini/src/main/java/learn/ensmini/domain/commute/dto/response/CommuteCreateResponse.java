package learn.ensmini.domain.commute.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommuteCreateResponse {

    private int status;
    private String msg;

    public CommuteCreateResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
