package enzosdev.elifoot.repository;

import enzosdev.elifoot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
