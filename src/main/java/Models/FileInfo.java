package Models;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private Long id ;
    private String originalFileName;
    private String storageFileName;
    private String type;
    private Long size;
}
