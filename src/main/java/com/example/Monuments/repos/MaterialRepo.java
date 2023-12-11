package com.example.Monuments.repos;

import com.example.Monuments.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepo extends JpaRepository<Material,Long> {
}
