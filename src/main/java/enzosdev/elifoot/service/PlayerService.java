package enzosdev.elifoot.service;

import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.entity.Player;
import enzosdev.elifoot.mapper.PlayerMapper;
import enzosdev.elifoot.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {


    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }



    public PlayerDTO createPlayer(PlayerDTO playerDTO){
        if(playerDTO.getName() == null || playerDTO.getName().isEmpty() || playerDTO.getShirtNumber() == null || playerDTO.getPosition() == null){
            throw new RuntimeException("The fields name, shirt number and position can not be empty, try again!");

        }
        Player player = playerMapper.map(playerDTO);
        player = playerRepository.save(player);
        return playerMapper.map(player);
    }


    public Page<PlayerDTO> findAllPlayer(Pageable pageable) {
        return playerRepository.findAll(pageable)
                .map(playerMapper::map);
    }
    }
