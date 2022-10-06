package com.iko.iko.domain.repository.reply;

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
}
