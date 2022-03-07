package club.tennis.tenol.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class GuestAttend extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guestAttendSeq;
    @ManyToOne
    @JoinColumn(name = "guest_seq", nullable = false)
    private Guest guest;
    private LocalDate dateAttend;

}
