package Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Coach {
    private Long id;
    private String firstName;
    private String lastName;
    private String experience;
    private String style;
}
