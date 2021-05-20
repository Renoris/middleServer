package com.study.fashionapp.dao.etc;

import com.study.fashionapp.data.etc.LargeCategory;
import com.study.fashionapp.data.etc.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallCategoryDao extends JpaRepository<SmallCategory , Integer>{

}
