package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.createPlayer(playerDTO);

    }



}
