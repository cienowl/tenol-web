package club.tennis.tenol.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Guest extends BaseEntity {
    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guestSeq;
    private String guestName;
    private String gender;
    @Builder.Default
    private Boolean blockFlag = false;
}
