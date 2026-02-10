package enzosdev.elifoot.mapper;

import enzosdev.elifoot.dto.LoginDTO;
import enzosdev.elifoot.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginDTO map(User user){
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(user.getId());
        loginDTO.setEmail(user.getEmail());
        return loginDTO;
    }
}
