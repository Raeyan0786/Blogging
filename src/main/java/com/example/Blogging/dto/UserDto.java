package com.example.Blogging.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty(message = "Name must NOT be empty !!!")
    @Size(min = 3, message = "Name must be of 3 character or more !!!")
    private String name;

    @Email(message = "Email is not valid !!!")
    private String email;




    @NotNull(message = "About field should not be blank !!!")
    private String about;
}
