package club.tennis.tenol.web.mapper;

import club.tennis.tenol.domain.Guest;
import club.tennis.tenol.web.dto.GuestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuestMapper {
    Guest toGuestEntity(GuestDTO guestDTO);
    GuestDTO toGuestDTO(Guest guest);
}
