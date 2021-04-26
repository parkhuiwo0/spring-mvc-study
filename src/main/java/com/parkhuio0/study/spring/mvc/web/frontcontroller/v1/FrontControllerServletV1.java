package com.parkhuio0.study.spring.mvc.web.frontcontroller.v1;

import com.parkhuio0.study.spring.mvc.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.parkhuio0.study.spring.mvc.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.parkhuio0.study.spring.mvc.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") // *에는 어떤 게 들어와서 이 서블릿을 통해 들어온다.
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI(); // "/front-controller/v1/members/new-form 이렇게 들어오는 것

        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) { // 페이지가 없거나, 못 찾을 때
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
