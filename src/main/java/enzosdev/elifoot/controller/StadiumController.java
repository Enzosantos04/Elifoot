package enzosdev.elifoot.controller;


import enzosdev.elifoot.dto.StadiumDTO;
import enzosdev.elifoot.service.StadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {


    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public Page<StadiumDTO> findAll(Pageable pageable){
        return stadiumService.findAll(pageable);
    }


    @PostMapping
    public StadiumDTO createStadium(@RequestBody StadiumDTO stadiumDTO){
        return stadiumService.createStadium(stadiumDTO);
    }


    @GetMapping("/{id}")
    public StadiumDTO findStadiumById(@PathVariable Long id){
        return stadiumService.findStadiumById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStadiumById(@PathVariable Long id){
      stadiumService.deleteStadiumById(id);
    }
}
