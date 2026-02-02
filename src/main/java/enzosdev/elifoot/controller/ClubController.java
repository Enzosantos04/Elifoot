package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.dto.PlayerDTO;
import enzosdev.elifoot.service.ClubService;
import enzosdev.elifoot.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;
    private final PlayerService playerService;

    public ClubController(ClubService clubService, PlayerService playerService) {
        this.clubService = clubService;
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<Page<ClubDTO>> findAll(Pageable pageable){
        Page<ClubDTO> clubs = clubService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(clubs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> findClubById(@PathVariable Long id){
        ClubDTO club = clubService.findClubById(id);
        return ResponseEntity.status(HttpStatus.OK).body(club);
    }


    @PostMapping
    public ResponseEntity<ClubDTO> createClub(@RequestBody ClubDTO clubDTO){
        ClubDTO club = clubService.createClub(clubDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(club);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClubById(@PathVariable Long id) {
        clubService.deleteClubById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ClubDTO> updateClubById(@PathVariable Long id, @RequestBody ClubDTO clubDTO) {
        ClubDTO club = clubService.updateClubById(id, clubDTO);
        return ResponseEntity.status(HttpStatus.OK).body(club);

    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<PlayerDTO>> getPlayersByClub(@PathVariable long id){
        List<PlayerDTO> players = playerService.findPlayersByClubId(id);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }



}
