package com.iko.iko.controller.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponseDto {

    private String accessToken;

    private String refreshToken;

    private String accessTokenExpiredDate;

    private String refreshTokenExpiredDate;

}
