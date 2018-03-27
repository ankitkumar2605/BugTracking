package com.iquery.controller;

import com.iquery.model.Bug;
import com.iquery.model.User;
import com.iquery.service.BugService;
import com.iquery.service.EmailService;
import com.iquery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@Controller
public class BugController {
    private UserService userService;
    private BugService bugService;

    @Autowired
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView showHomePage(ModelAndView modelAndView, Bug bug) {
        System.out.println("...in home page.......");
        modelAndView.addObject("bug", bug);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createBug(ModelAndView modelAndView, @Valid Bug bug, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            System.out.println(".....in if.....");
            modelAndView.setViewName("home");
        } else {
            System.out.println("....in else....");
            bugService.saveBug(bug);
            modelAndView.addObject("successMessage", "Bug has been created");
            return new ModelAndView("redirect:/home");
        }
        return modelAndView;
    }
}
