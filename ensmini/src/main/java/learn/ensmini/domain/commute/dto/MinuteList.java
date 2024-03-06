package learn.ensmini.domain.commute.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class MinuteList {

    private String date;
    private int workingMinutes;

    public MinuteList(String date, int workingMinutes) {
        this.date = date;
        this.workingMinutes = workingMinutes;
    }
}
