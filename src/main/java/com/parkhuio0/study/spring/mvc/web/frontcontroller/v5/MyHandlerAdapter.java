package com.parkhuio0.study.spring.mvc.web.frontcontroller.v5;

import com.parkhuio0.study.spring.mvc.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse responses, Object handler) throws ServletException, IOException;
}
