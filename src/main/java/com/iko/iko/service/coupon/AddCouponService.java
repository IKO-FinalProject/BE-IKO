package com.iko.iko.service.coupon;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.domain.entity.Member;
import com.iko.iko.domain.repository.linkMemberCoupon.LinkMemberCouponRepository;
import com.iko.iko.domain.repository.member.MemberRepository;
import com.iko.iko.controller.coupon.dto.request.CouponRequestDto.*;
import com.iko.iko.security.jwt.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddCouponService {

    private final LinkMemberCouponRepository linkMemberCouponRepository;
    private final MemberRepository memberRepository;

    public String addCoupon(AddCouponRequest addCouponRequest){
        Member member = validateLoginStatus();
    }

    public Member validateLoginStatus() {
        return memberRepository.findByEmail(SecurityUtil.getLoginUserEmail())
                .orElseThrow(() -> new BaseException(ErrorCode.NEED_LOGIN));
    }
}
