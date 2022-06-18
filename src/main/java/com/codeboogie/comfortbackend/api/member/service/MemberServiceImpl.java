package com.codeboogie.comfortbackend.api.member.service;

import com.codeboogie.comfortbackend.common.member.domain.dto.MemberDTO;
import com.codeboogie.comfortbackend.common.member.domain.model.Member;
import com.codeboogie.comfortbackend.common.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public boolean createMember(MemberDTO memberDTO){
        try{
            Member comfortMember = new Member();
            comfortMember.setUserId(memberDTO.getUserId());
            comfortMember.setUserName(memberDTO.getUserName());


            Member member = memberRepository.findByUserId(memberDTO.getUserId());
            System.out.println("11"+member);

            if (member == null) {
                memberRepository.save(comfortMember);
            }

        } catch (Exception e){
            System.out.println("이전에 가입한 사용자 로그인 중......");
            e.printStackTrace();
        }
        return true;
    }

}
