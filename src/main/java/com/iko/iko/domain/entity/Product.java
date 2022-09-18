package com.iko.iko.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@Table(name = "tb_product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id_pk",unique = true,nullable = false)
    private Integer product_id;

    @Column(name = "image_id_fk")
    @NotEmpty
    private Image image_id;

    @Column(name ="product_name", nullable = false)
    @NotEmpty
    private String name;


    @Column(name ="manufacturer", nullable = false)
    @NotEmpty
    private String manufacturer;

    @Column(name ="total_recommend", nullable = true)
    @NotEmpty
    private boolean recommend;

    @Column(name="series", nullable = false)
    @NotEmpty
    private String series;

    @Column(name="feature", nullable = false)
    @NotEmpty
    private String feature;

    @Column(name="discount",nullable = true)
    @NotEmpty
    private float discount;

    @Column(name="product_stock",nullable = false)
    @NotEmpty
    private Integer stock;

    @Column(name="price")
    @NotEmpty
    private Integer price;

    @Column(name="graphic_diameter")
    @NotEmpty
    private float graphic_diameter;


}