package com.iko.iko.service.reply;

import com.iko.iko.controller.reply.dto.response.ReplyResponseDtO;
import com.iko.iko.domain.repository.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GetReplyDataService {
    private final ReplyRepository replyRepository;

    public ReplyResponseDtO.ReplyInfoForResponse getReplyData(Integer productId){
        List<ReplyResponseDtO.ReplyData> replyDataList= replyRepository.getReplyData(productId);

        ReplyResponseDtO.ReplyInfoForResponse result=new ReplyResponseDtO.ReplyInfoForResponse(
                replyDataList.size(),
                replyDataList
        );
        return result;
    }
}
