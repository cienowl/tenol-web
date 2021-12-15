package club.tennis.tenol.service;

import club.tennis.tenol.domain.Guest;
import club.tennis.tenol.exception.NoDataException;
import club.tennis.tenol.repository.GuestRepository;
import club.tennis.tenol.web.dto.GuestDTO;
import club.tennis.tenol.web.dto.GuestSearchDTO;
import club.tennis.tenol.web.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class GuestService {
    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Transactional(readOnly = true)
    public Guest findGuest(Long guestSeq) throws NoDataException {
        return guestRepository.findById(guestSeq)
                .orElseThrow(() -> new NoDataException("guest.error.nodata"));
    }

    @Transactional(readOnly = true)
    public List<GuestDTO> findGuestList(GuestSearchDTO guestSearchDTO) {
        return guestRepository.findAllGuests(guestSearchDTO);
    }

    @Transactional(readOnly = true)
    public List<GuestDTO> findGuestByGuestName(String guestName) {
        return guestRepository.findByGuestNameIsLike(guestName).stream()
                .map(guestMapper::toGuestDTO)
                .collect(Collectors.toList());
    }
}
