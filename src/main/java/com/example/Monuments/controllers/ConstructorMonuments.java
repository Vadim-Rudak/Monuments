package com.example.Monuments.controllers;

import com.example.Monuments.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConstructorMonuments {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping("/Constructor")
    public String seeConstructor(HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        dashboardService.seeUserForDashboard(ipAddress,3);
        return "edit_page";
    }
}
