package com.study.fashionapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.fashionapp.data.PictureData;

public interface PictureDao extends JpaRepository<PictureData, Integer> {
}
