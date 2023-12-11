package com.example.Monuments.repos;

import com.example.Monuments.domain.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepo extends JpaRepository<Stat,Long> {
    List<Stat> findByMonthAndPage(int num_month,int page);
    List<Stat> findByIpAndPage(String ip,int page);
    List<Stat> findByDayAndMonthAndYearAndPage(int day,int month,int year,int page);
    List<Stat> findByPage(int page);
}
