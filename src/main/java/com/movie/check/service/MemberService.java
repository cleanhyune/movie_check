package com.movie.check.service;

import com.movie.check.domain.Member;
import com.movie.check.repository.member.MemberRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMemberById(Long id) throws NotFoundException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

}
