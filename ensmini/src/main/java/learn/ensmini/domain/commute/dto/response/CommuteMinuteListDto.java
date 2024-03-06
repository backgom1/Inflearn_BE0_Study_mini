package learn.ensmini.domain.commute.dto.response;

import learn.ensmini.domain.commute.dto.MinuteList;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CommuteMinuteListDto {
    private List<MinuteList> detail;
    private int sum;

    public CommuteMinuteListDto(List<MinuteList> detail, int sum) {
        this.detail = detail;
        this.sum = sum;
    }
}
