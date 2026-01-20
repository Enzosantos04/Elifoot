package enzosdev.elifoot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StadiumDTO {


    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String city;

    private Integer capacity;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String urlImg;

}
