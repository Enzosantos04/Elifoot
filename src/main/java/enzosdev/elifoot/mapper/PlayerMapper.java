package enzosdev.elifoot.mapper;

import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerDTO map(Player player){
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setPosition(player.getPosition());
        dto.setShirtNumber(player.getShirtNumber());
        dto.setUrlImg(player.getUrlImg());
        dto.setClub(player.getClub());

        return dto;

    }


    public Player map(PlayerDTO playerDTO){
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setPosition(playerDTO.getPosition());
        player.setShirtNumber(playerDTO.getShirtNumber());
        player.setUrlImg(playerDTO.getUrlImg());
        player.setClub(playerDTO.getClub());

        return player;

    }
}
