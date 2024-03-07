package learn.ensmini.global.dto.response;


import learn.ensmini.global.dto.ValidMsg;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CommonErrorResponse {

    private int status;
    private List<ValidMsg> validation;

    public CommonErrorResponse(int status, List<ValidMsg> errMsg) {
        this.status = status;
        this.validation = errMsg;
    }
}
