package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public Page<ClubDTO> findAll(Pageable pageable){
        return clubService.findAll(pageable);
    }


    @GetMapping("/{id}")
    public ClubDTO findClubById(@PathVariable Long id){
        return clubService.findClubById(id);
    }


    @PostMapping
    public ClubDTO createClub(@RequestBody ClubDTO clubDTO){
        return clubService.createClub(clubDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClubById(@PathVariable Long id) {
        clubService.deleteClubById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}")
    public ClubDTO updateClubById(@PathVariable Long id, @RequestBody ClubDTO clubDTO) {
        return clubService.updateClubById(id, clubDTO);

    }



}
