package com.eneselibol.springbootcrud.dto;

import com.eneselibol.springbootcrud.model.User;
import lombok.Getter;

import java.io.Serializable;
@Getter
public final class UserViewDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private final String firstName;
    private final String lastName;

    public UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getFirstName(),user.getLastName());
    }
}
