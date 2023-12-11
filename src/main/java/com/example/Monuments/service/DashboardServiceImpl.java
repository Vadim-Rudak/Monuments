package com.example.Monuments.service;

import com.example.Monuments.domain.Stat;
import com.example.Monuments.other.classes.CompareUserDate;
import com.example.Monuments.other.interfaces.CompareDate;
import com.example.Monuments.repos.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    private StateRepo stateRepo;

    @Override
    public void seeUserForDashboard(String userIp, int numPage) {
        System.out.println("see=>" + userIp);

        LocalDate date = LocalDate.now();
        CompareDate compareDate = new CompareUserDate();
        List<Stat> listUserSee = stateRepo.findByIpAndPage(userIp,numPage);

        if(listUserSee.size()==0||compareDate.check(listUserSee)){

            Stat stat = new Stat();
            stat.setIp(userIp);
            stat.setDay(date.getDayOfMonth());
            stat.setMonth(date.getMonthValue());
            stat.setYear(date.getYear());
            stat.setPage(numPage);
            stateRepo.save(stat);
        }
    }

}
