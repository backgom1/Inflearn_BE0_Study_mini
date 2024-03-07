package learn.ensmini.global.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidMsg {

    private String msg;

    public ValidMsg(String msg) {
        this.msg = msg;
    }
}
