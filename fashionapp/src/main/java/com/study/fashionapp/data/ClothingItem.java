package com.study.fashionapp.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothingItem {
    private int id;
    private String title;
    private String price;
    private String search_word;
    private String link;
    private String image_link;
    private String vector;
}
