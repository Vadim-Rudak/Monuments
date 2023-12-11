package com.example.Monuments.other.classes;

import com.example.Monuments.domain.Stat;
import com.example.Monuments.other.interfaces.CompareDate;

import java.time.LocalDate;
import java.util.List;

public class CompareUserDate implements CompareDate {

    @Override
    public Boolean check(List<Stat> ls) {
        boolean seeFirstInDay = false;
        LocalDate date = LocalDate.now();

        if (ls.size()!=0){
            for(int i=0;i<ls.size();i++){
                seeFirstInDay = false;
                Stat seeStat = ls.get(i);
                if(seeStat.getYear()!=date.getYear()){
                    seeFirstInDay = true;
                }
                if (seeStat.getMonth()!=date.getMonthValue()){
                    seeFirstInDay = true;
                }
                if (seeStat.getDay()!=date.getDayOfMonth()){
                    seeFirstInDay = true;
                }
            }
        }
        return seeFirstInDay;
    }
}
