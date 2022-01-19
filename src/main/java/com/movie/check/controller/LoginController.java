package com.movie.check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ModelAndView login(HttpSession session) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("msg", "hello");
        session.setAttribute("session", "hyune");
        return mv;
    }

}
