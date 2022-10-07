package com.iko.iko.controller.coupon;

import com.iko.iko.common.response.Response;
import com.iko.iko.service.coupon.facade.CouponFacade;
import com.iko.iko.controller.coupon.dto.request.CouponRequestDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponFacade couponFacade;

    @PostMapping("/add")
    public ResponseEntity<Response<String>> addCoupon(
            @RequestBody @Valid AddCouponRequest addCouponRequest) {
        return ResponseEntity.ok(
                Response.of(couponFacade.addCoupon(addCouponRequest),
                        "쿠폰 발급 완료")
        );
    }
}
