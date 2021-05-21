package com.study.fashionapp.dao;

import com.study.fashionapp.data.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClothDao extends JpaRepository<Cloth, Integer> {
}
