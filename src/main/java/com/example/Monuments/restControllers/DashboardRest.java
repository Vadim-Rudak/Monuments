package com.example.Monuments.restControllers;

import com.example.Monuments.repos.StateRepo;
import com.example.Monuments.service.DashboardDaysWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DashboardRest {

    @Autowired
    private DashboardDaysWeek dashboardDaysWeek;

    @Autowired
    private StateRepo stateRepo;

    @RequestMapping(value = "/getInfoGraf1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getInfoGraf1(){
        return dashboardDaysWeek.getPeopleInDaysOfWeek();
    }

    @RequestMapping(value = "/getInfoGraf2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getInfoGraf2(){
        List<Integer> ls = new ArrayList<>();
        ls.add(stateRepo.findByPage(1).size());
        ls.add(stateRepo.findByPage(2).size());
        ls.add(stateRepo.findByPage(3).size());

        return ls;
    }
}
