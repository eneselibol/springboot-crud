package com.eneselibol.springbootcrud.service;

import com.eneselibol.springbootcrud.dto.UserCreateDTO;
import com.eneselibol.springbootcrud.dto.UserUpdateDTO;
import com.eneselibol.springbootcrud.dto.UserViewDTO;

import java.util.List;


public interface UserService {
    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(long id);
}
