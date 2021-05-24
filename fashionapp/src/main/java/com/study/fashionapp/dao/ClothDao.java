package com.study.fashionapp.dao;

import com.study.fashionapp.data.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClothDao extends JpaRepository<Cloth, Integer> {
    public List<Cloth> findAllBySmallcategory(String smallcategory);

}
