package com.example.Monuments.repos;

import com.example.Monuments.domain.Catalog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepo extends JpaRepository<Catalog,Long> {
    List<Catalog> findByCategory(int category, Sort sort);
}
