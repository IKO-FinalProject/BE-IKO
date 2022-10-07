package com.iko.iko.service.coupon.facade;

import com.iko.iko.controller.coupon.dto.request.CouponRequestDto.*;
import com.iko.iko.service.coupon.AddCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CouponFacade {

    private final AddCouponService addCouponService;
    @Transactional
    public String addCoupon(AddCouponRequest addCouponRequest){
        return addCouponService.addCoupon(addCouponRequest);
    }
}
