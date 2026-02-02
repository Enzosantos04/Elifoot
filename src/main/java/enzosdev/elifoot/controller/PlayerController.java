package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO){
        PlayerDTO player = playerService.createPlayer(playerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);

    }

    @GetMapping
    public ResponseEntity<Page<PlayerDTO>> findAllPlayer(Pageable pageable){
        Page<PlayerDTO> players = playerService.findAllPlayer(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayerById(@PathVariable Long id){
        playerService.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayerById(@PathVariable Long id, @RequestBody PlayerDTO playerDTO){
        PlayerDTO player = playerService.updatePlayerById(id, playerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(player);
    }




}
