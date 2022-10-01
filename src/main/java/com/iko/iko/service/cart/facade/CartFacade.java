package com.iko.iko.service.cart.facade;

import com.iko.iko.controller.cart.dto.request.AddCartRequestDto;
import com.iko.iko.service.cart.AddCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartFacade {

    private final AddCartService addCartService;

    @Transactional
    public Long addCart(AddCartRequestDto requestDto){
        return addCartService.addCart(requestDto);
    }
}
