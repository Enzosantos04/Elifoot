package enzosdev.elifoot.service;

import enzosdev.elifoot.dto.LoginDTO;
import enzosdev.elifoot.dto.LoginResponseDTO;
import enzosdev.elifoot.entity.Scope;
import enzosdev.elifoot.entity.User;
import enzosdev.elifoot.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;


    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }


    public LoginResponseDTO login(LoginDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        List<String> scopes = user.getScopes().stream()
                .map(Scope::getName)
                .toList();

        long expiresIn = 600L;
        JwtClaimsSet jwtClaims = JwtClaimsSet.builder()
                .issuer("elifoot")
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .subject( user.getEmail())
                .claim("scope", scopes)
                .claim("email", user.getEmail())
                .build();
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaims)).getTokenValue();

        return LoginResponseDTO.builder()
                .token(token)
                .expiresIn(expiresIn)
                .build();

    }

    private boolean isPasswordValid(String password, String savedPassword){
        return passwordEncoder.matches(password, savedPassword);
    }



}