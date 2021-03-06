package com.study.fashionapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothingDataSecond {
    private ClothingDataSecond smallcategory;
    private ArrayList<Cloth> list;
}
