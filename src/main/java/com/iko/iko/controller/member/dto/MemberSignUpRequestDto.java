package com.iko.iko.controller.member.dto;

import com.iko.iko.common.Role;
import com.iko.iko.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@Builder
public class MemberSignUpRequestDto {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotNull(message = "이름 읽는 법을 입력해주세요.")
    private String readname;

    private Integer postCode;

    private String address;

    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;

    private String birthday;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    private String checkedPassWord;

    private Role role;


    @Builder
    public Member toEntity(){
        return Member.builder()
                .name(name)
                .readname(readname)
                .postCode(postCode)
                .address(address)
                .phone(phone)
                .email(email)
                .birthday(birthday)
                .password(password)
                .role(Role.USER)
                .build();
    }
}
