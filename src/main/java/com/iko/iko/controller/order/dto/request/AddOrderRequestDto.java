package com.iko.iko.controller.order.dto.request;

import com.iko.iko.domain.entity.LinkOrderDetails;
import com.iko.iko.domain.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Builder
@AllArgsConstructor
public class AddOrderRequestDto {

    private String name;
    private String phone;
    private String email;
    private String receiverName;
    private String address;
    private String detailAddress;
    private String receiverPhone;
    private String message;
    private List<ProductDetailsSetRequest> ProductDetailsSetRequestList;
    private Integer couponId;
    private String method;
    private Integer totalPrice;
    private Integer point;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class ProductDetailsSetRequest {

        private Integer productDetailsId;
        private Integer set;

        @Builder
        public LinkOrderDetails toEntity(){
            return LinkOrderDetails.builder()
                    .productDetailsId(productDetailsId)
                    .set(set)
                    .build();
        }
    }

    @Builder
    public Order toEntity(){
        return Order.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .receiverName(receiverName)
                .destination(address)
                .detailDestination(detailAddress)
                .receiverPhone(receiverPhone)
                .message(message)
                .couponId(couponId)
                .method(method)
                .totalPrice(totalPrice)
                .point(point)
                .build();
    }

}
