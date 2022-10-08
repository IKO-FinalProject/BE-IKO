package com.iko.iko.controller.reply.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

public class ReplyResponseDtO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MyReplyInfoResponse{
        private MyReplyAndIdsResponse replyInfo;
        private List<ProductInfoForReplyResponse> productInfo;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MyReplyAndIdsResponse {
        private Integer replyId;
        private Date replyCreatedAt;
        private Integer orderId;
        private String replyImageUrl;
        private Float replyRating;
        private String replyComment;
        private Integer productDetailsId;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProductInfoForReplyResponse {
        private String productName;
        private String color;
        private Float graphicDiameter;
        private Float degree;
        private Integer pcs;
        private Integer period;
        private String productImageUrl;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReplyData{
        private Float rating;
        private Integer memberId;
        private String color;
        private Float graphicDiameter;
        private Integer period;
        private String content;
        private String imageUrl;
        private java.sql.Date createdAt;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReplyDataResponse{
        private Float rating;
        private String email;
        private String color;
        private Float graphicDiameter;
        private Integer period;
        private String content;
        private String imageUrl;
        private java.sql.Date createdAt;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReplyInfoForResponse{
        private Integer totalCount;
        private List<ReplyDataResponse> replyDataResponse;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReplyInfoForMain{
        private String imageUrl;
        private String productName;
        private String email;
        private Float rating;
    }

}
