package enzosdev.elifoot.service;


import enzosdev.elifoot.dto.StadiumDTO;
import enzosdev.elifoot.entity.Stadium;
import enzosdev.elifoot.mapper.StadiumMapper;
import enzosdev.elifoot.repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public Page<StadiumDTO> findAll(Pageable pageable){
        return stadiumRepository
                .findAll(pageable)
                .map(stadiumMapper::map);
    }


    public StadiumDTO createStadium(StadiumDTO stadiumDTO){

        if (stadiumDTO.getName().isEmpty() || stadiumDTO.getCity().isEmpty() || stadiumDTO.getCity().isBlank()){
            throw new RuntimeException("Stadium can not be empty, try again");
        } else {
            Stadium stadium = stadiumMapper.map(stadiumDTO);
            stadium = stadiumRepository.save(stadium);
            return stadiumMapper.map(stadium);
        }

    }

    public StadiumDTO findStadiumById(Long id){
        Optional<Stadium> stadium = stadiumRepository.findById(id);
        return stadium.map(stadiumMapper::map).orElseThrow(()-> new RuntimeException("Stadium not found"));
    }


    public StadiumDTO deleteStadiumById(Long id){
        if (findStadiumById(id) == null){
            throw new RuntimeException("Stadium Not found");
        }
        stadiumRepository.deleteById(id);
        return null;
    }


}
