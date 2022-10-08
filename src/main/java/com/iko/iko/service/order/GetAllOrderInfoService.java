package com.iko.iko.service.order;

import com.iko.iko.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetAllOrderInfoService {

    private final OrderRepository orderRepository;


}
