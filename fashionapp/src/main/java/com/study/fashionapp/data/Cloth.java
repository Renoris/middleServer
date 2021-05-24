package com.study.fashionapp.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="cloth")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String largecategory;
    @Column
    private String smallcategory;
    @Column
    private String title;
    @Column
    private String price;
    @Column
    private String link;
    @Column
    private String imagelink;
    @Column
    private String vector;
}
