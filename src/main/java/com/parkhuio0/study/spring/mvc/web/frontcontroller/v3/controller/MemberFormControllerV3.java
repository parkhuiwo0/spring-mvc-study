package com.parkhuio0.study.spring.mvc.web.frontcontroller.v3.controller;

import com.parkhuio0.study.spring.mvc.web.frontcontroller.ModelView;
import com.parkhuio0.study.spring.mvc.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
