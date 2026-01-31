package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<PlayerDTO> findAllPlayer(Pageable pageable){
        return playerService.findAllPlayer(pageable);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayerById(@PathVariable Long id){
        playerService.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }




}
