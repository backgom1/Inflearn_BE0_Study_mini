package learn.ensmini.global.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TeamErrorResponse {

    private int status;
    private String errMsg;
}
