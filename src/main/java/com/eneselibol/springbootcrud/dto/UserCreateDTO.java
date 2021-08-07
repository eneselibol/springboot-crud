package com.eneselibol.springbootcrud.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

    @NotNull(message = "{springbootcrud.constraints.firstname.NotNull.message}")
    @Size(min = 2, max = 32,message = "{springbootcrud.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{springbootcrud.constraints.lastname.NotNull.message}")
    @Size(min = 3, max = 32,message = "{springbootcrud.constraints.lastname.Size.message}")
    private String lastName;

}
