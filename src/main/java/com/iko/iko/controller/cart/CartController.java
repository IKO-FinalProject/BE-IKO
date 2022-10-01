package com.iko.iko.controller.cart;

import com.iko.iko.controller.cart.dto.request.AddCartRequestDto;
import com.iko.iko.controller.cart.dto.response.CartListResponseDto;
import com.iko.iko.service.cart.facade.CartFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    // 장바구니 조회
    @GetMapping("list")
    public List<CartListResponseDto> cartList() {
        return cartFacade.cartList();
    }

}
