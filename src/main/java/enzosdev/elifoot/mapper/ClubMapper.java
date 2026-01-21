package enzosdev.elifoot.mapper;


import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.entity.Club;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {

    public ClubDTO map(Club club){
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setFounded(club.getFounded());
        dto.setUrlImg(club.getUrlImg());

        return dto;
    }


    public Club map(ClubDTO clubDTO){
        Club club = new Club();
        club.setId(club.getId());
        club.setName(club.getName());
        club.setFounded(club.getFounded());
        club.setUrlImg(clubDTO.getUrlImg());

        return club;
    }
}
