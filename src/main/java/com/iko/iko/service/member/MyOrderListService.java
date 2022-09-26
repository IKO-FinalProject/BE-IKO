package com.iko.iko.service.member;


import com.iko.iko.controller.member.dto.response.MyOrderListResponseDto;
import com.iko.iko.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyOrderListService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MyOrderListResponseDto> MyOrderList(Integer memberId){
        return memberRepository.MyOrderList(memberId);
    }
}
