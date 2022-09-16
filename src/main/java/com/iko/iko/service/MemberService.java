package com.iko.iko.service;

import com.iko.iko.presentation.dto.request.MemberSignInRequestDto;
import com.iko.iko.presentation.dto.request.MemberSignUpRequestDto;

public interface MemberService {

    // 회원가입
    Integer signUp(MemberSignUpRequestDto requestDto);
    String login(MemberSignInRequestDto requestDto);
}
