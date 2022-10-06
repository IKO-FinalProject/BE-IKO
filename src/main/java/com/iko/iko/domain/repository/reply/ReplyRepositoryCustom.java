package com.iko.iko.domain.repository.reply;

import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.UpdateReplyRequest;

public interface ReplyRepositoryCustom {

    Long deleteReply(Integer replyId);

    Long updateReply(UpdateReplyRequest updateReplyRequest);
}
