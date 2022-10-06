package com.iko.iko.domain.repository.reply;

import com.iko.iko.controller.reply.dto.response.ReplyResponseDtO.*;
import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.UpdateReplyRequest;
import com.iko.iko.domain.entity.Reply;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.iko.iko.domain.entity.QImage.image;
import static com.iko.iko.domain.entity.QProduct.product;
import static com.iko.iko.domain.entity.QProductDetails.productDetails;
import static com.iko.iko.domain.entity.QReply.reply;
import static com.iko.iko.domain.entity.QLinkOrderDetails.linkOrderDetails;
import static com.iko.iko.domain.entity.QLinkProductDetailsImage.linkProductDetailsImage;
@Repository
@RequiredArgsConstructor
public class ReplyRepositoryImpl implements ReplyRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Long deleteReply(
            Integer replyId
    ) {
        return jpaQueryFactory
                .delete(reply)
                .where(reply.replyId.eq(replyId))
                .execute();
    }

    @Override
    public Long updateReply(
            UpdateReplyRequest updateReplyRequest
    ) {
        return jpaQueryFactory
                .update(reply)
                .set(reply.content, updateReplyRequest.getContent())
                .set(reply.rating, updateReplyRequest.getRating())
                .set(reply.imageUrl, updateReplyRequest.getImageUrl())
                .where(reply.replyId.eq(updateReplyRequest.getReplyId()))
                .execute();
    }

    @Override
    public List<MyReplyAndIdsResponse> getMyReplyAndIdsInfo(
            Integer memberId
    ) {
        return jpaQueryFactory
                .select(Projections.constructor(MyReplyAndIdsResponse.class,
                        reply.replyId,
                        reply.createdAt,
                        reply.orderId,
                        reply.imageUrl,
                        reply.rating,
                        reply.content,
                        reply.productDetailsId
                ))
                .from(reply)
                .where(reply.memberId.eq(memberId))
                .orderBy(reply.createdAt.desc())
                .fetch();
    }

    @Override
    public List<ProductInfoForReplyResponse> getProductInfoForReply(
            Integer orderId, Integer productDetailsId
    ) {
        return jpaQueryFactory
                .select(Projections.constructor(ProductInfoForReplyResponse.class,
                        product.name,
                        productDetails.color,
                        productDetails.graphicDiameter,
                        productDetails.degree,
                        linkOrderDetails.pcs,
                        productDetails.period,
                        image.imageUrl
                ))
                .from(productDetails)
                .join(product).on(productDetails.productIdFk.eq(product.productId)).fetchJoin()
                .join(linkOrderDetails).on(productDetails.productDetailsId.eq(linkOrderDetails.productDetailsId)
                        .and(linkOrderDetails.orderId.eq(orderId))).fetchJoin()
                .join(linkProductDetailsImage).on(productDetails.productDetailsId.eq(linkProductDetailsImage.productDetailsId)).fetchJoin()
                .join(image).on(linkProductDetailsImage.imageId.eq(image.imageId)
                        .and(image.imageType.eq(1))).fetchJoin()
                .distinct()
                .where(productDetails.productDetailsId.eq(productDetailsId))
                .fetch();
    }

    @Override
    public List<Reply> getReplyList(
            Integer orderId, Integer productDetailsId
    ){
        return jpaQueryFactory
                .selectFrom(reply)
                .where(reply.orderId.eq(orderId)
                        .and(reply.productDetailsId.eq(productDetailsId)))
                .fetch();
    }

}
