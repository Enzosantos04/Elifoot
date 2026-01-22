package enzosdev.elifoot.service;


import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.entity.Club;
import enzosdev.elifoot.entity.Stadium;
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
                      .orElseThrow(() -> new RuntimeException("Club Not found."));
    }

    public ClubDTO createClub(ClubDTO clubDTO){
        Club club = clubMapper.map(clubDTO);
        club = clubRepository.save(club);
        return clubMapper.map(club);

    }
}
