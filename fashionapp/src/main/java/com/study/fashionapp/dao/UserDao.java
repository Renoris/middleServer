package com.study.fashionapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.fashionapp.data.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
