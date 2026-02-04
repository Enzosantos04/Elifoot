package enzosdev.elifoot.service;


import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.dto.StadiumDTO;
import enzosdev.elifoot.entity.Club;
import enzosdev.elifoot.entity.Stadium;
import enzosdev.elifoot.exceptions.ClubNotFoundException;
import enzosdev.elifoot.exceptions.FieldsEmptyException;
import enzosdev.elifoot.mapper.ClubMapper;
import enzosdev.elifoot.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public ClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }



    public Page<ClubDTO> findAll(Pageable pageable){
     return clubRepository.findAll(pageable)
             .map(clubMapper::map);
    }


    public ClubDTO findClubById(Long id){
        Optional<Club> club = clubRepository.findById(id);
              return club.map(clubMapper::map)
                      .orElseThrow(() -> new ClubNotFoundException("Club Not found."));
    }

    public ClubDTO createClub(ClubDTO clubDTO){
        if(clubDTO.getName() == null || clubDTO.getName().isEmpty() || clubDTO.getFounded() == null){
            throw new FieldsEmptyException("Club's Name and foundation can not be empty");
        }
        Club club = clubMapper.map(clubDTO);
        club = clubRepository.save(club);
        return clubMapper.map(club);

    }
    public void deleteClubById(Long id){
        if(!clubRepository.existsById(id)){
            throw new ClubNotFoundException("Club Not Found");
        }
        clubRepository.deleteById(id);
    }

    public ClubDTO updateClubById(Long id, ClubDTO clubDTO){

        Club club = clubRepository.findById(id)
                .orElseThrow(()-> new ClubNotFoundException("Club not found"));

        if(clubDTO.getName() == null || clubDTO.getName().isEmpty() || clubDTO.getFounded() == null){
            throw new FieldsEmptyException("Club's Name and foundation can not be empty");
        }

        club.setName(clubDTO.getName());
        club.setFounded(clubDTO.getFounded());
        club.setUrlImg(clubDTO.getUrlImg());

        Club updatedClub = clubRepository.save(club);
        return clubMapper.map(updatedClub);
    }
}
