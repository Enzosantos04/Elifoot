package enzosdev.elifoot.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseDTO {

    private String token;
    private Long expiresIn;
}
