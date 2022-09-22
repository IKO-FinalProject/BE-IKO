package com.iko.iko.controller.member;

import com.iko.iko.controller.member.dto.request.MemberSignInRequestDto;
import com.iko.iko.controller.member.dto.request.MemberSignUpRequestDto;
import com.iko.iko.controller.member.dto.response.MemberResponseDto;
import com.iko.iko.controller.member.dto.response.ReissueResponseDto;
import com.iko.iko.controller.member.dto.response.TokenResponseDto;
import com.iko.iko.service.member.facade.MemberFacade;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberFacade memberFacade;

    public MemberController(MemberFacade memberFacade) {
        this.memberFacade = memberFacade;
    }

    // 회원가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public Integer signUp(@Valid @RequestBody MemberSignUpRequestDto requestDto) {
        return memberFacade.signUp(requestDto);
    }

    // 로그인
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid MemberSignInRequestDto requestDto) {
        return memberFacade.login(requestDto);
    }


    // 토큰 재발급
    @ApiOperation(value = "토큰 재발급", notes = "토큰을 재발급한다")
    @PostMapping("/newAccess")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-ACCESS-TOKEN", value = "access-token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "X-REFRESH-TOKEN", value = "refresh-token", required = true, dataType = "String", paramType = "header")
    })
    public ReissueResponseDto issueAccessToken(
            @RequestHeader(value="X-ACCESS-TOKEN") String token,
            @RequestHeader(value="X-REFRESH-TOKEN") String refreshToken ) {
        return memberFacade.issueAccessToken(token, refreshToken);
    }

    @GetMapping("/info")
    public MemberResponseDto findMyInfo(){
        return memberFacade.findMyInfo();
    }


}
