package enzosdev.elifoot.controller;


import enzosdev.elifoot.config.annotations.CanReadPlayer;
import enzosdev.elifoot.config.annotations.CanWriteStadium;
import enzosdev.elifoot.dto.StadiumDTO;
import enzosdev.elifoot.service.StadiumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {


    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:read', 'SCOPE_admin:all')")
    @GetMapping
    public ResponseEntity<Page<StadiumDTO>> findAll(Pageable pageable){
        Page<StadiumDTO> stadiumDTO = stadiumService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(stadiumDTO);
    }

    @CanWriteStadium
    @PostMapping
    public ResponseEntity<StadiumDTO> createStadium(@Valid @RequestBody StadiumDTO stadiumDTO){
        StadiumDTO newStadium = stadiumService.createStadium(stadiumDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStadium);
    }

    @CanReadPlayer
    @GetMapping("/{id}")
    public ResponseEntity<StadiumDTO> findStadiumById(@PathVariable Long id){
        StadiumDTO stadiumDTO = stadiumService.findStadiumById(id);
        return ResponseEntity.status(HttpStatus.OK).body(stadiumDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStadiumById(@PathVariable Long id){
      stadiumService.deleteStadiumById(id);
      return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StadiumDTO> updateStadiumById(@PathVariable Long id, @RequestBody StadiumDTO stadiumDTO){
        StadiumDTO updatedStadium = stadiumService.updateStadiumById(id, stadiumDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStadium);
    }
}
