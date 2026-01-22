package enzosdev.elifoot.service;


import enzosdev.elifoot.dto.ClubDTO;
import enzosdev.elifoot.mapper.ClubMapper;
import enzosdev.elifoot.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
