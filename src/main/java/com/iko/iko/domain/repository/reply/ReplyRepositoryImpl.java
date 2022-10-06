package com.iko.iko.domain.repository.reply;

import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.UpdateReplyRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.iko.iko.domain.entity.QReply.reply;
@Repository
@RequiredArgsConstructor
public class ReplyRepositoryImpl implements ReplyRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Long deleteReply(
            Integer replyId
    ){
         return jpaQueryFactory
                 .delete(reply)
                 .where(reply.replyId.eq(replyId))
                 .execute();
    }

    @Override
    public Long updateReply(
            UpdateReplyRequest updateReplyRequest
    ){
        return jpaQueryFactory
                .update(reply)
                .set(reply.content, updateReplyRequest.getContent())
                .set(reply.rating, updateReplyRequest.getRating())
                .set(reply.imageUrl, updateReplyRequest.getImageUrl())
                .where(reply.replyId.eq(updateReplyRequest.getReplyId()))
                .execute();
    }
}
