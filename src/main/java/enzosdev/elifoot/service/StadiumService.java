package enzosdev.elifoot.service;


import enzosdev.elifoot.repository.StadiumRepository;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;


    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }



}
