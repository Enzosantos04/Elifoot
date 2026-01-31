package enzosdev.elifoot.repository;


import enzosdev.elifoot.entity.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findPlayersByClubId(Long clubId);
}
