package enzosdev.elifoot.service;

import enzosdev.elifoot.dto.LoginDTO;
import enzosdev.elifoot.entity.User;
import enzosdev.elifoot.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public LoginDTO login(LoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getEmail());
        if (optionalUser.isEmpty() || !isPasswordValid(loginDTO.getPassword(), optionalUser.get().getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }
        return loginDTO;
    }

    private boolean isPasswordValid(String password, String savedPassword){
        return passwordEncoder.matches(password, savedPassword);
    }

}