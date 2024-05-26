package com.app.api.member.dto;

import com.app.domain.member.constant.Role;
import com.app.domain.member.entity.Member;
import com.app.global.dto.BaseResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class MemberInfoResponseDto extends BaseResponseDto {
    private Long memberId;
    private String email;
    private String memberName;
    private String profile;
    private Role role;

    public static MemberInfoResponseDto of(Member member) {
        return MemberInfoResponseDto.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .email(member.getEmail())
                .profile(member.getProfile())
                .role(member.getRole())
                .build();
    }
}
