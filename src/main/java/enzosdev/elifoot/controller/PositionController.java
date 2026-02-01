package enzosdev.elifoot.controller;

import enzosdev.elifoot.dto.PositionDTO;
import enzosdev.elifoot.enums.Position;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/enums/position")
public class PositionController {


    @GetMapping
    public List<PositionDTO> getPositionsEnums(){
        return Arrays.stream(Position.values())
                .map(position -> new PositionDTO(position.name(), position.getLabel()))
                .toList();
    }
}
