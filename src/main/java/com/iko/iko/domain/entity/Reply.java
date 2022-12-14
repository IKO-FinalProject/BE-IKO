package com.iko.iko.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tb_reply")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id_pk", unique = true, nullable = false)
    private Integer replyId;

    @Column(name = "member_id_fk" , nullable = false)
    private Integer memberId;

    @Column(name = "product_details_id_fk" , nullable = false)
    private Integer productDetailsId;

    @Column(name = "order_id_fk" , nullable = false)
    private Integer orderId;

    @Column(name = "content")
    private String content;

    @Column(name = "rating" , nullable = false)
    private Float rating;

    @Column(name = "image_url")
    private String imageUrl;

}
