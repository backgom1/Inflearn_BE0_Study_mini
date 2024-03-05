package learn.ensmini.domain.team.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

/**
 * 팀 생성에 대한 요청 객체
 * @author dmstjd
 * @since 2024-03-05
 * @version v0.0.1
 */
@Getter
public class TeamCreateRequest {
    @NotNull(message = "팀 이름은 필수 입니다.")
    private String name;
    private String manager;
    private int memberCount;
    private int annualRole;
}
