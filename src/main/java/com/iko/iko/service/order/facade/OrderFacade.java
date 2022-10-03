package com.iko.iko.service.order.facade;

import com.iko.iko.controller.order.dto.request.OrderRequestDto.CancelOrderRequest;
import com.iko.iko.controller.order.dto.request.OrderRequestDto.AddOrderRequest;
import com.iko.iko.controller.order.dto.response.OrderResponseDto.GetOrderResponse;
import com.iko.iko.controller.order.dto.request.OrderRequestDto.GetOrderRequest;
import com.iko.iko.service.order.AddOrderService;
import com.iko.iko.service.order.CancelOrderService;
import com.iko.iko.service.order.GetOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderFacade {

    private final AddOrderService addOrderService;
    private final CancelOrderService cancelOrderService;
    private final GetOrderService getOrderService;

    @Transactional
    public Integer addOrder(AddOrderRequest addOrderRequest){
        return addOrderService.addOrder(addOrderRequest);
    }

    @Transactional
    public String cancelOrder(CancelOrderRequest cancelOrderRequest){
        return cancelOrderService.cancelOrder(cancelOrderRequest);
    }

    @Transactional(readOnly = true)
    public List<GetOrderResponse> getOrder(GetOrderRequest getOrderRequest){
        return getOrderService.getOrder(getOrderRequest);
    }

}
