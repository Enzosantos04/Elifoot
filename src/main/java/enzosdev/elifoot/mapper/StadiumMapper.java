package enzosdev.elifoot.mapper;


import enzosdev.elifoot.dto.StadiumDTO;
import enzosdev.elifoot.entity.Stadium;
import org.springframework.stereotype.Component;

@Component
public class StadiumMapper {

    public StadiumDTO map(Stadium stadium){
        StadiumDTO dto = new StadiumDTO();
        dto.setId(stadium.getId());
        dto.setName(stadium.getName());
        dto.setCity(stadium.getCity());
        dto.setCapacity(stadium.getCapacity());
        dto.setUrlImg(stadium.getUrlImg());

        return dto;
    }


    public Stadium map(StadiumDTO stadiumDTO){
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDTO.getId());
        stadium.setName(stadiumDTO.getName());
        stadium.setCity(stadiumDTO.getCity());
        stadium.setCapacity(stadiumDTO.getCapacity());
        stadium.setUrlImg(stadiumDTO.getUrlImg());

        return stadium;
    }
}
