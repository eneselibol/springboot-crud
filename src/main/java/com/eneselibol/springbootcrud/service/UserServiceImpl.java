package com.eneselibol.springbootcrud.service;

import com.eneselibol.springbootcrud.dto.UserCreateDTO;
import com.eneselibol.springbootcrud.dto.UserUpdateDTO;
import com.eneselibol.springbootcrud.dto.UserViewDTO;
import com.eneselibol.springbootcrud.exception.UserNotFoundException;
import com.eneselibol.springbootcrud.model.User;
import com.eneselibol.springbootcrud.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
        final User user= userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user=userRepository.save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user= userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found Exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        final User updatedUser=userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        final User user= userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found Exception"));
        userRepository.deleteById(user.getId());

    }
}
