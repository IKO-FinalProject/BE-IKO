package com.iko.iko.service.reply.facade;

import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.*;
import com.iko.iko.service.reply.AddReplyService;
import com.iko.iko.service.reply.DeleteReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyFacade {

    private final AddReplyService addReplyService;
    private final DeleteReplyService deleteReplyService;

    @Transactional
    public String addReply(AddReplyRequest addReplyRequest){
        return addReplyService.addReply(addReplyRequest);
    }

    @Transactional
    public String deleteReply(DeleteReplyRequest deleteReplyRequest){
        return deleteReplyService.deleteReply(deleteReplyRequest);
    }
}
