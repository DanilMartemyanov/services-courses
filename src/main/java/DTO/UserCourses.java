package DTO;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCourses {
    private String courses;
    private String nameCourses;
}
