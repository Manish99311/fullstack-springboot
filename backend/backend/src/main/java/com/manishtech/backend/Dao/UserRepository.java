package com.manishtech.backend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manishtech.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
