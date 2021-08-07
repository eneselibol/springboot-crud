package com.eneselibol.springbootcrud.repository;

import com.eneselibol.springbootcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.firstName from User u where u='ali' ")
    List<User> getAllByName();

}
