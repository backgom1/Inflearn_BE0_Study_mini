package learn.ensmini.domain.team.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class TeamListResponseDto {

    private String name;
    private String manager;
    private int memberCount;

    public TeamListResponseDto(String name, String manager, int memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }
}
