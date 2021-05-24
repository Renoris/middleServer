package com.study.fashionapp.services;

import com.study.fashionapp.dao.ClothDao;
import com.study.fashionapp.data.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ClothService {
    private ClothDao clothDao;

    @Autowired
    public ClothService(ClothDao clothDao){
        this.clothDao=clothDao;
    }

    public ArrayList<Cloth> findTag(String tag){
        return new ArrayList<>(clothDao.findAllBySmallcategory(tag));
    }

    public ArrayList<Cloth> findAllId(ArrayList<Integer> list){
        return new ArrayList<>(clothDao.findAllById(list));
    }
}
