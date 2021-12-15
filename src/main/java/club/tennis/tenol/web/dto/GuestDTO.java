package club.tennis.tenol.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestDTO {
    @Schema(title = "게스트 일련번호", example = "1")
    private Long guestSeq;
    @Schema(title = "게스트 이름", example = "김개똥")
    private String guestName;
    @Schema(title = "게스트 성별", example = "MALE/FEMALE")
    private String gender;
    @Schema(title = "블락리스트 여부", example = "false")
    private Boolean blockFlag;
}
