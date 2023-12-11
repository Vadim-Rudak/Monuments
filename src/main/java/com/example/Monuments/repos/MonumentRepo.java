package com.example.Monuments.repos;

import com.example.Monuments.domain.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepo extends JpaRepository<Monument,Long> {
    List<Monument> findByType(int type);
}
