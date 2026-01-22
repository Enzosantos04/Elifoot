package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
