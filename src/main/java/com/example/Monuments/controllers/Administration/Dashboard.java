package com.example.Monuments.controllers.Administration;

import com.example.Monuments.domain.Month;
import com.example.Monuments.other.interfaces.DateForState;
import com.example.Monuments.other.classes.StateUseDate;
import com.example.Monuments.repos.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Dashboard {

    @Autowired
    private StateRepo stateRepo;

    @RequestMapping("/dashboard")
    public String dashboard( Model model){

        model.addAttribute("LastMonth",getListTitelGraf());

        return "Administration/AdminPageDashboard";
    }

    List<Month> getListTitelGraf(){
        DateForState dateForState = new StateUseDate();
        List<Month> lastMonth = dateForState.getMonthWithNow();
        for(int i=0; i<lastMonth.size();i++){
            Month ms = lastMonth.get(i);
            ms.setPeople(stateRepo.findByMonthAndPage(ms.getNum(),1).size());
        }

        return lastMonth;
    }

}
