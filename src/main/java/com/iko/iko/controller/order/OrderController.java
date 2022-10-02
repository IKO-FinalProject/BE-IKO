package com.iko.iko.controller.order;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.order.dto.request.AddOrderRequestDto;
import com.iko.iko.service.order.facade.OrderFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade){
        this.orderFacade = orderFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<Response<String>> addOrder(
            @RequestBody @Valid AddOrderRequestDto addOrderRequestDto
    ){
        return ResponseEntity.ok(
                Response.of(orderFacade.addOrder(addOrderRequestDto),
                        "주문 완료"
                )
        );
    }

}
