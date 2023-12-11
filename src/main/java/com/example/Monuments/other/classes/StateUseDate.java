package com.example.Monuments.other.classes;

import com.example.Monuments.domain.Month;
import com.example.Monuments.other.interfaces.DateForState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StateUseDate implements DateForState {

    String[] months  = new String[] {"ЯНВАРЬ", "ФЕВРАЛЬ", "МАРТ", "АПРЕЛЬ","МАЙ","ИЮНЬ","ИЮЛЬ","АВГУСТ","СЕНТЯБРЬ","ОКТЯБРЬ","НОЯБРЬ","ДЕКАБРЬ"};

    @Override
    public List<Month> getMonthWithNow() {
        LocalDate today = LocalDate.now();
        int month_now = today.getMonthValue();
        List<Month> listMonths = new ArrayList<>();

        Month month;
        for(int k=1;k<6;k++){
            month = new Month();
            if (month_now==0){
                month.setNum(12);
                month_now = 11;
            }else{
                month.setNum(month_now);
                month_now--;
            }
            month.setName(months[month_now]);

            listMonths.add(month);
        }

        Collections.reverse(listMonths);
        return listMonths;
    }
}
