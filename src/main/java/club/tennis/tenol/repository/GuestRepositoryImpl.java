package club.tennis.tenol.repository;

import club.tennis.tenol.util.CollectionUtil;
import club.tennis.tenol.web.dto.GuestDTO;
import club.tennis.tenol.web.dto.GuestSearchDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static club.tennis.tenol.domain.QGuest.guest;

@RequiredArgsConstructor
public class GuestRepositoryImpl implements GuestRepositoryCustom {
    private final JPQLQueryFactory queryFactory;

    @Override
    public List<GuestDTO> findAllGuests(GuestSearchDTO guestSearchDTO) {
        return queryFactory.select(Projections.bean(GuestDTO.class,
                        guest.guestSeq,
                        guest.guestName,
                        guest.gender,
                        guest.blockFlag
                ))
                .from(guest)
                .where(
                        eqGuestSeq(guestSearchDTO.getGuestSeq()),
                        eqGuestName(guestSearchDTO.getGuestName()),
                        eqGender(guestSearchDTO.getGender()),
                        eqBlockFlag(guestSearchDTO.getBlockFlag())
                )
                .fetch();
    }

    private BooleanExpression eqGuestSeq(Long guestSeq) {
        if (CollectionUtil.isEmpty(guestSeq)) {
            return null;
        } else {
            return guest.guestSeq.eq(guestSeq);
        }
    }
    private BooleanExpression eqGuestName(String guestName) {
        if (CollectionUtil.isEmpty(guestName)) {
            return null;
        } else {
            return guest.guestName.eq(guestName);
        }
    }
    private BooleanExpression eqGender(String gender) {
        if (CollectionUtil.isEmpty(gender)) {
            return null;
        } else {
            return guest.gender.eq(gender);
        }
    }
    private BooleanExpression eqBlockFlag(Boolean blockFlag) {
        if (CollectionUtil.isEmpty(blockFlag)) {
            return null;
        } else {
            return guest.blockFlag.eq(blockFlag);
        }
    }
}
