package club.tennis.tenol.web.rest;

import club.tennis.tenol.exception.NoDataException;
import club.tennis.tenol.service.GuestService;
import club.tennis.tenol.web.dto.GuestDTO;
import club.tennis.tenol.web.dto.GuestSearchDTO;
import club.tennis.tenol.web.mapper.GuestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "02. Guest", description = "게스트 서비스")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/guest")
public class GuestRestController {
    private final GuestService guestService;
    private final GuestMapper guestMapper;

    @Operation(summary = "게스트 조회", description = "guestSeq로 게스트를 조회한다")
    @GetMapping("/{guestSeq}")
    public GuestDTO findGuest(@PathVariable("guestSeq") Long guestSeq) throws NoDataException {
        return guestMapper.toGuestDTO(guestService.findGuest(guestSeq));
    }

    @Operation(summary = "게스트 전체 조회", description = "모든 게스트 정보를 조회한다.")
    @GetMapping("/list")
    public List<GuestDTO> findGuestList(GuestSearchDTO guestSearchDTO) {
        return guestService.findGuestList(guestSearchDTO);
    }

    @GetMapping("")
    public List<GuestDTO> findGuestByGuestName(@RequestParam String guestName) throws NoDataException {
        return guestService.findGuestByGuestName(guestName);
    }
}
