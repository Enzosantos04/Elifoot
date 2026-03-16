package enzosdev.elifoot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
