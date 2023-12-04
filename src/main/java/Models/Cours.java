package Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Cours {
    private Long id;
    private String style;
    private String coach;
    private String duration;
    private String discription;
    private String schedule;

}
