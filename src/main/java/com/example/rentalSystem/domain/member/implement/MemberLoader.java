package com.example.rentalSystem.domain.member.implement;

import com.example.rentalSystem.domain.member.entity.Member;
import com.example.rentalSystem.domain.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberLoader {

    private final MemberRepository memberRepository;

    public boolean checkExistEmail(String memberEmail) {
        return memberRepository.existsByEmail(memberEmail);
    }

    public Member findByLoginId(String memberLoginId) {
        return memberRepository.findByLoginId(memberLoginId).orElseThrow(
            (() -> new EntityNotFoundException(
                "member not found :" + memberLoginId)));
    }
}