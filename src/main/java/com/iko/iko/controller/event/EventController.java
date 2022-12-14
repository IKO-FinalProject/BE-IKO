package com.iko.iko.controller.event;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.event.dto.EventResponse;
import com.iko.iko.service.event.facade.EventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventFacade eventFacade;

    @GetMapping("/main")
    public ResponseEntity<Response<EventResponse.EventMainResponse>>
    getEventMain(){
        return ResponseEntity.ok(
                Response.of(
                        eventFacade.getEventMain(),
                        "이벤트 목록 불러오기 완료"
                )
        );
    }

    @GetMapping("/details")
    public ResponseEntity<Response<List<EventResponse.EventDetails>>>
    getEventDetails(
            @RequestParam(value = "eventId") Integer selectedEventId
    ){
        return ResponseEntity.ok(
                Response.of(
                eventFacade.getEventDetails(selectedEventId),
                "이벤트 상세 페이지 불러오기 완료"
                )
        );
    }

}
