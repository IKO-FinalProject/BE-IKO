package com.iko.iko.service;

import com.iko.iko.controller.member.dto.MemberSignUpRequestDto;

public interface MemberService {

    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;

}
