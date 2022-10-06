package com.iko.iko.controller.reply;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.reply.dto.request.ReplyRequestDto.AddReplyRequest;
import com.iko.iko.service.reply.facade.ReplyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("reply")
public class ReplyController {

    private final ReplyFacade replyFacade;
    @PostMapping("/add")
    public ResponseEntity<Response<String>> addReply(
            @RequestBody @Valid AddReplyRequest addReplyRequest
    ) {
        return ResponseEntity.ok(
                Response.of(replyFacade.addReply(addReplyRequest),
                        "리뷰 작성 완료")
        );
    }

}
