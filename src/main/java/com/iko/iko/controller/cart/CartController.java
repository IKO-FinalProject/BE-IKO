package com.iko.iko.controller.cart;

import com.iko.iko.controller.cart.dto.request.AddCartRequestDto;
import com.iko.iko.service.cart.facade.CartFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/cart")
@RestController
public class CartController {

    private final CartFacade cartFacade;

    public CartController(CartFacade cartFacade){
        this.cartFacade = cartFacade;
    }

    // 장바구니 추가
    @PostMapping("/add")
    public ResponseEntity addCart (@RequestBody @Valid AddCartRequestDto requestDto){
        cartFacade.addCart(requestDto);
        return new ResponseEntity<>("장바구니 추가 완료", HttpStatus.OK);
    }

}
