package com.iko.iko.service.order;

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

    private final OrderRepository orderRepository;
    private final LinkOrderDetailsRepository linkOrderDetailsRepository;

//    @Transactional
//    public Long addOrder(AddOrderRequestDto requestDto){
//        Order order = orderRepository.save(requestDto.toEntity());
//        LinkOrderDetails linkOrderDetails = linkOrderDetailsRepository.save(requestDto.product)
//    }
}
