package enzosdev.elifoot.entity;

import enzosdev.elifoot.enums.Position;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Position position;
    private Integer shirtNumber;
    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
