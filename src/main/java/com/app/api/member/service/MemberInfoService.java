package com.app.api.member.service;

import com.app.api.member.dto.MemberInfoResponseDto;
import com.app.domain.member.entity.Member;
import com.app.domain.member.service.MemberService;
import com.app.global.resolver.memberInfo.MemberInfoDto;
import com.app.global.util.DtoDecryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final MemberService memberService;

    @Transactional(readOnly = true)
    public MemberInfoResponseDto getMemberInfo(MemberInfoDto memberInfoDto) {

        String encKey = "";
        MemberInfoDto decMemberInfoDto = DtoDecryptUtil.decryptFields(memberInfoDto,encKey);
        Long memberId = Long.valueOf(decMemberInfoDto.getMemberId());
        Member member = memberService.findMemberByMemberId(memberId);
        return MemberInfoResponseDto.of(member);
    }

}
