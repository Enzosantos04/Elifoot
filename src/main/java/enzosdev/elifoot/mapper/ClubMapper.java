package enzosdev.elifoot.mapper;


import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.entity.Club;
import enzosdev.elifoot.entity.Stadium;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {

    public ClubDTO map(Club club){
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setFounded(club.getFounded());
        dto.setUrlImg(club.getUrlImg());
        if(club.getStadium() != null){
            dto.setStadiumId(club.getStadium().getId());
        }
        dto.setStadium(club.getStadium());
        return dto;
    }


    public Club map(ClubDTO clubDTO){
        Club club = new Club();
        club.setId(clubDTO.getId());
        club.setName(clubDTO.getName());
        club.setFounded(clubDTO.getFounded());
        club.setUrlImg(clubDTO.getUrlImg());
        if(clubDTO.getStadiumId() != null){
            Stadium stadium = new Stadium();
            stadium.setId(clubDTO.getStadiumId());
            club.setStadium(stadium);
        }

        return club;
    }
}
