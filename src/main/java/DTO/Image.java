package DTO;

import lombok.*;

@Data
@Builder
public class Image {
    private String originalFileName;
    private String type;
}
