package com.example.Monuments.repos;

import com.example.Monuments.domain.PhotoWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoWorkRepo extends JpaRepository<PhotoWork,Long> {
//    PhotoWork findById(Long id);
}
