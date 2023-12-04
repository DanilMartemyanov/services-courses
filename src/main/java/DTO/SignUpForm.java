package DTO;

import lombok.*;

import java.util.Date;


@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password ;
}
