package com.iko.iko.service.order;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.order.dto.request.AddOrderRequestDto;
import com.iko.iko.domain.entity.LinkOrderDetails;
import com.iko.iko.domain.entity.Order;
import com.iko.iko.domain.repository.linkOrderDetails.LinkOrderDetailsRepository;
import com.iko.iko.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddOrderService {

//    private final OrderRepository orderRepository;
//    private final LinkOrderDetailsRepository linkOrderDetailsRepository;
//
//    @Transactional
//    public String addOrder(AddOrderRequestDto addOrderRequestDto){
//        Order order = orderRepository.save(addOrderRequestDto.toEntity());
//        if(order.getOrderId() == null){
//            throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
//        }
//
//        int idx = 0;
//    }
}
