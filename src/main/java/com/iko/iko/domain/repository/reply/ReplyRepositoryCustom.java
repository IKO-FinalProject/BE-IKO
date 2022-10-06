package com.iko.iko.domain.repository.reply;

import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.UpdateReplyRequest;
import com.iko.iko.controller.reply.dto.response.ReplyResponseDtO.*;
import com.iko.iko.domain.entity.Reply;

import java.util.List;


public interface ReplyRepositoryCustom {

    Long deleteReply(Integer replyId);

    Long updateReply(UpdateReplyRequest updateReplyRequest);

    List<MyReplyAndIdsResponse> getMyReplyAndIdsInfo(Integer memberId);

    List<ProductInfoForReplyResponse> getProductInfoForReply(Integer orderId, Integer productDetailsId);

    List<Reply> getReplyList(Integer orderId, Integer productDetailsId);
}
