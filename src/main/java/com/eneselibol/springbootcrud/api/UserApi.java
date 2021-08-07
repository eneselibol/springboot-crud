package com.eneselibol.springbootcrud.api;

import com.eneselibol.springbootcrud.dto.UserCreateDTO;
import com.eneselibol.springbootcrud.dto.UserUpdateDTO;
import com.eneselibol.springbootcrud.dto.UserViewDTO;
import com.eneselibol.springbootcrud.model.User;
import com.eneselibol.springbootcrud.service.UserService;
import com.eneselibol.springbootcrud.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApi {

    private final UserService userService;

    @GetMapping("/v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        final UserViewDTO user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> users=userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO user=userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted!");
    }
}
