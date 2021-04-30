package com.parkhuio0.study.spring.mvc.web.frontcontroller.v4.controller;

import com.parkhuio0.study.spring.mvc.domain.member.Member;
import com.parkhuio0.study.spring.mvc.domain.member.MemberRepository;
import com.parkhuio0.study.spring.mvc.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
