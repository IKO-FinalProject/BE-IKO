package com.iko.iko.controller;

import com.iko.iko.domain.repository.member.MemberRepository;
import com.iko.iko.presentation.dto.request.MemberSignInRequestDto;
import com.iko.iko.presentation.dto.request.MemberSignUpRequestDto;
import com.iko.iko.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public Integer signUp(@Valid @RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.signUp(requestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody @Valid MemberSignInRequestDto requestDto) {
        return memberService.login(requestDto);
    }


}
