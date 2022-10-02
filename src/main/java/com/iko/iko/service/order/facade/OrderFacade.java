package com.iko.iko.service.order.facade;

import com.iko.iko.controller.order.dto.request.AddOrderRequestDto;
import com.iko.iko.service.order.AddOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderFacade {

    private final AddOrderService addOrderService;

    @Transactional
    public String addOrder(AddOrderRequestDto addOrderRequestDto){
        return addOrderService.addOrder(addOrderRequestDto);
    }

}
