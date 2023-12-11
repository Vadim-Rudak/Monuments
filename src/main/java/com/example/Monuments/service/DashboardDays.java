package com.example.Monuments.service;

import com.example.Monuments.domain.DayDash;
import com.example.Monuments.repos.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardDays implements DashboardDaysWeek{

    String[] days = new String[]{" ","Пн","Вт","Ср","Чт","Пт","Сб","Вс"};

    @Autowired
    private StateRepo stateRepo;

    @Override
    public List<DayDash> getPeopleInDaysOfWeek() {
        List<DayDash> list = new ArrayList<>();
        LocalDate date = LocalDate.now();
        int i = date.getDayOfWeek().getValue();

        for(int j = i+1;j<=7;j++){
            list.add(new DayDash(days[j],0));
        }
        for (int k=1;k<=i;k++){
            list.add(new DayDash(days[k],0));
        }

        for(int z=0;z<7;z++){
            LocalDate dt = date.minusDays(z);
            list.get(list.size()-1-z).setPeople(getPeopleInDay(dt));
        }

        return list;
    }

    int getPeopleInDay(LocalDate dateSee){
        return stateRepo.findByDayAndMonthAndYearAndPage(dateSee.getDayOfMonth(),dateSee.getMonthValue(),dateSee.getYear(),1).size();
    }
}
