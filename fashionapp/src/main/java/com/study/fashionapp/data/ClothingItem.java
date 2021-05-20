package com.study.fashionapp.data;


import lombok.Data;

@Data
public class ClothingItem {
    private int id;
    private String title;
    private String price;
    private String search_word;
    private String link;
    private String image_link;
    private String vector;
}
