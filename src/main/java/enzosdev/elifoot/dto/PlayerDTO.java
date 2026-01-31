package enzosdev.elifoot.dto;

import enzosdev.elifoot.entity.Club;
import enzosdev.elifoot.enums.Position;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Position position;
    @NotBlank
    private Integer shirtNumber;
    private String urlImg;

    private Long clubId;

    private Club club;


}
