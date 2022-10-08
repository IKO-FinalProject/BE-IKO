package com.iko.iko.service.reply;

import com.iko.iko.controller.reply.dto.response.ReplyResponseDtO;
import com.iko.iko.domain.repository.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetReplyMainService {
    private  final ReplyRepository replyRepository;

    public List<ReplyResponseDtO.ReplyInfoForMain> getReplyMain(){

    }
}
