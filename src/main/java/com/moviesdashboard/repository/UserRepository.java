package com.moviesdashboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.moviesdashboard.model.User;


    public interface UserRepository extends JpaRepository<User ,String> , JpaSpecificationExecutor<User>{

        Optional<User> findByEmail(String email);
        Optional<User> findByUserName(String userName);

}
