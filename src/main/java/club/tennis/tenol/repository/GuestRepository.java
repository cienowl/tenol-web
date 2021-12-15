package club.tennis.tenol.repository;

import club.tennis.tenol.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long>, GuestRepositoryCustom {
    Optional<Guest> findByGuestNameIsLike(String guestName);
}
