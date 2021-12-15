package club.tennis.tenol.repository;

import club.tennis.tenol.web.dto.GuestDTO;
import club.tennis.tenol.web.dto.GuestSearchDTO;

import java.util.List;

public interface GuestRepositoryCustom {
    List<GuestDTO> findAllGuests(GuestSearchDTO guestSearchDTO);
}
