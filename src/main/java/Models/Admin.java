package Models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Admin {
    private Long id;
    private String firstName;
    private String email;
}
