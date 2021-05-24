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
public class PutFlaskData {
    String original;
    String tag;
    ArrayList<TagVector> Item;
}
