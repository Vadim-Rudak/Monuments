package com.example.Monuments.repos;

import com.example.Monuments.domain.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementRepo extends JpaRepository<Element,Long> {
    Element findById(int id);
    List<Element> findByType(int type);
}
