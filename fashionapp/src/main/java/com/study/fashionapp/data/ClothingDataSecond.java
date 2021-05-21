package com.study.fashionapp.data;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ClothingDataSecond {
    private ClothingDataSecond smallcategory;
    private ArrayList<Cloth> list;
}
