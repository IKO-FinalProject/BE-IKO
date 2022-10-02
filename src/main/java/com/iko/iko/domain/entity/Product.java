package com.iko.iko.domain.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@ToString
@Table(name = "tb_product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id_pk",unique = true,nullable = false)
    private Integer productId;

    private String manufacturer;

    private String series;

    private String feature;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer discount;

    @Column(name="product_stock",nullable = false)
    private Integer stock;

    @Column(name ="product_name")
    private String name;

    @Column(name="price")
    private Integer price;

    @Column(name ="recommend",nullable = false)
    private Integer recommend;

    private Integer exposure;

    @Column(name="diameter" )
    private Float diameter;

}
