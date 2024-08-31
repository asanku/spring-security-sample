package com.demo.SpringSecEx.repo;

import com.demo.SpringSecEx.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}



//plain text -> cipher text (using key)
//plain -> hash1 -> hash2 ....
