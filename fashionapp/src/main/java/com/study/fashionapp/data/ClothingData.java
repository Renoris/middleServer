package com.study.fashionapp.data;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ClothingData {
    private String category_name1;
    private String category_name2;
    private ArrayList<ClothingItem> list;
}
